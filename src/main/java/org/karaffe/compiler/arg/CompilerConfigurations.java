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
package org.karaffe.compiler.arg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.report.ReportType;
import org.karaffe.compiler.report.Reporter;
import org.karaffe.io.KaraffeFile;
import org.karaffe.io.KaraffeFileStream;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerConfigurations implements KaraffeFileStream, Reporter {

    @Option(name = "--version", aliases = "-version", usage = "Show compiler version")
    private boolean hasVersion;

    @Option(name = "-vv", aliases = "--debug", usage = "log in debug mode")
    private boolean isDebugMode;

    @Option(name = "-v", aliases = "--verbose", usage = "log in verbose mode")
    private boolean isVerboseMode;

    @Option(name = "--parallel", usage = "build in parallel")
    private boolean isParallelMode;

    @Option(name = "--log-output", usage = "log message to FILE")
    private File logFile;

    private boolean isArgumentsError;

    @Argument
    private List<File> sourceFiles = new ArrayList<>();

    private final List<Report> reports = new ArrayList<>();

    public boolean hasVersion() {
        return hasVersion;
    }

    public boolean isDebugMode() {
        return isDebugMode;
    }

    public boolean isVerboseMode() {
        return isVerboseMode;
    }

    public boolean isParallelMode() {
        return isParallelMode;
    }

    @Override
    public boolean hasFile() {
        return !sourceFiles.isEmpty();
    }

    public boolean hasLogOutputFile() {
        return logFile != null;
    }

    public File getLogFile() {
        return logFile;
    }

    public PrintStream getLogStream() {
        try {
            return new PrintStream(logFile);
        } catch (FileNotFoundException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public Stream<KaraffeFile> getFileStream() {
        List<KaraffeFile> karaffeFiles = sourceFiles
                .stream()
                .map(File::toPath)
                .map(KaraffeFile::of)
                .map(e -> {
                    return e.bimap(left -> {
                        Report report = Report
                                .builder()
                                .title("IOError : " + left.getLocalizedMessage())
                                .type(ReportType.ERROR).build();
                        reports.add(report);
                        return null;
                    }, right -> {
                        return right;
                    });
                })
                .filter(e -> e.isRight())
                .map(e -> e.right().value())
                .collect(toList());

        return karaffeFiles.stream();
    }

    public Stream<File> getFileParallelStream() {
        return sourceFiles.parallelStream();
    }

    public void setArgumentsError() {
        this.isArgumentsError = true;
    }

    public boolean isArgumentsError() {
        return isArgumentsError;
    }

    @Override
    public String toString() {
        return "CommandLineOptions{"
                + "hasVersion="
                + hasVersion
                + ", isDebugMode="
                + isDebugMode
                + ", isVerboseMode="
                + isVerboseMode
                + ", isParallelMode="
                + isParallelMode
                + ", sourceFiles="
                + sourceFiles + '}';
    }

    @Override
    public boolean isEmpty() {
        return sourceFiles.isEmpty();
    }

    @Override
    public List<Report> getReports() {
        return reports;
    }

}
