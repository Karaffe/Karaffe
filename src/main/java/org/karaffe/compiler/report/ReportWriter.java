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
package org.karaffe.compiler.report;

import java.io.PrintStream;
import java.util.List;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
public class ReportWriter {

    private final PrintStream writer;

    public ReportWriter() {
        this(System.err);
    }

    public ReportWriter(PrintStream writer) {
        this.writer = writer;
    }

    public void printReport(KaraffeFile file, List<Report> reports) {
        List<String> sources = file.getSource();
        reports.forEach(r -> {
            if (r.hasLineInfo()) {
                writer.println(r.getType() + ": " + r.getTitle());
                writer.println(r.getPlace() + " at " + r.getLine() + ":" + r.getColumn() + "~" + r.getEndColumn());
                String line = sources.get(r.getLine() - 1);
                System.out.println(line);
                for (int i = 0; i < r.getColumn(); i++) {
                    writer.print(' ');
                }
                System.out.print('^');
                for (int i = 0; i < r.getEndColumn() - r.getColumn(); i++) {
                    writer.print('~');
                }
                writer.println();
            } else {
                writer.println(r.getType() + ": " + r.getTitle());
                writer.println(r.getPlace());
            }
        });
    }

    public void printReport(List<Report> reports) {
        reports.forEach(r -> {
            writer.println(r.getType() + ": " + r.getTitle());
            writer.println(r.getPlace());
        });
    }

}
