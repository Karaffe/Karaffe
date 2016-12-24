/*
 * The MIT License
 *
 * Copyright 2016 Karaffe.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.karaffe.compiler.runner;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.ExitStatus;
import org.karaffe.compiler.arg.CompilerConfigurations;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.report.ReportWriter;
import org.karaffe.compiler.tree.CompileUnit;
import org.karaffe.io.KaraffeFileStream;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerRunner {

    private final KaraffeFileStream files;
    private final ReportWriter reportWriter;

    public CompilerRunner() {
        this.files = KaraffeFileStream.emptyStream();
        this.reportWriter = new ReportWriter();
    }

    public CompilerRunner(KaraffeFileStream fileStream) {
        this.files = fileStream;
        this.reportWriter = new ReportWriter();
    }

    public CompilerRunner(CompilerConfigurations config) {
        this.files = config;
        if (config.hasLogOutputFile()) {
            this.reportWriter = new ReportWriter(config.getLogStream());
        } else {
            this.reportWriter = new ReportWriter();
        }
    }

    public ExitStatus run() {
        if (files.isEmpty()) {
            return ExitStatus.EX_IOERR;
        }
        files.getFileStream()
                .map(f -> {
                    return new Parser(f);
                })
                .map(parser -> parser.getCompileUnit())
                .map(r -> {
                    CompileUnit compileUnit = r.getCompileUnit();
                    List<Report> reports = r.getReports();
                    reportWriter.printReport(compileUnit.getFile(), reports);
                    return compileUnit;
                });
        return ExitStatus.EX_OK;
    }

}
