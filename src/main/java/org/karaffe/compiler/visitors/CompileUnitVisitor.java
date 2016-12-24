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

import java.util.List;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.NamingException;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.tree.CompileUnit;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
public class CompileUnitVisitor extends KaraffeBaseVisitor<CompileUnit> {

    private final KaraffeFile file;

    public CompileUnitVisitor(KaraffeFile file) {
        this.file = file;
    }

    @Override
    public CompileUnit visitCompileUnit(KaraffeParser.CompileUnitContext compileUnitContext) {
        CompileUnit compileUnit = new CompileUnit(file);
        List<KaraffeParser.StatementContext> statementContexts = compileUnitContext.statement();
        for (KaraffeParser.StatementContext context : statementContexts) {
            ClassDeclVisitor classDeclVisitor = new ClassDeclVisitor();
            try {
                ClassDecl classDecl = context.accept(classDeclVisitor);
                compileUnit.addStatement(classDecl);
            } catch (NamingException e) {
                System.err.println(e);
            }
        }
        return compileUnit;
    }

}
