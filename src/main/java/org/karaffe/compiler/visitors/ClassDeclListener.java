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
package org.karaffe.compiler.visitors;

import java.util.ArrayList;
import java.util.List;
import org.karaffe.compiler.antlr.KaraffeBaseListener;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.tree.ClassDecl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author noko
 */
public class ClassDeclListener extends KaraffeBaseListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassDeclListener.class);

    private final List<ClassDecl> classDecls = new ArrayList<>();
    private final List<Report> reports = new ArrayList<>();

    @Override
    public void exitClassDecl(KaraffeParser.ClassDeclContext classDeclContext) {
        LOGGER.info("enter class decl");
        KaraffeParser.ClassNameContext classNameContext = classDeclContext.className();
        String className = classNameContext.getText();
        LOGGER.debug("className : " + className);
        if (Character.isLowerCase(className.charAt(0))) {
            Report report
                    = Report.builder()
                            .title("The class name must begin with an uppercase letter.")
                            .type("Error")
                            .line(classNameContext.getStart().getLine())
                            .column(classNameContext.getStart().getCharPositionInLine())
                            .endColumn(classNameContext.getStart().getCharPositionInLine() + className.length() - 1)
                            .build();
            reports.add(report);
        }
        KaraffeParser.ClassBodyBlockContext classBodyBlock = classDeclContext.classBodyBlock();
        ClassDecl classDecl = new ClassDecl(className);
        classDecls.add(classDecl);
    }

    public List<ClassDecl> getDeclaredClasses() {
        return classDecls;
    }

    public List<Report> getReports() {
        return reports;
    }

    public boolean hasError() {
        return !reports.isEmpty();
    }
}
