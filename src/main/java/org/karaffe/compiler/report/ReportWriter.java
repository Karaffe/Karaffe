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

import java.util.List;
import org.karaffe.compiler.Constants;

/**
 *
 * @author noko
 */
public class ReportWriter {

    public void printReports(String fileName, List<String> sources, List<Report> reports) {
        reports.forEach(r -> {
            System.out.println(r.getType() + ": " + r.getTitle() + Constants.NEW_LINE + fileName + " at " + r.getLine() + ":" + r.getColumn() + "~" + r.getEndColumn());
            String line = sources.get(r.getLine() - 1);
            System.out.println(line);
            for (int i = 0; i < r.getColumn(); i++) {
                System.out.print(' ');
            }
            System.out.print('^');
            for (int i = 0; i < r.getEndColumn() - r.getColumn(); i++) {
                System.out.print('~');
            }
            System.out.println();
        });
    }
}
