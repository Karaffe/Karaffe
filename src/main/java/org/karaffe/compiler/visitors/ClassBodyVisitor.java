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

import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.tree.FieldDecl;
import org.karaffe.compiler.tree.FuncDecl;
import org.karaffe.compiler.tree.Statement;
import org.karaffe.compiler.tree.meta.Scope;

/**
 *
 * @author noko
 */
@Slf4j
public class ClassBodyVisitor extends KaraffeBaseVisitor<Statement> {

    private final Scope scope;
    private final ClassDecl parent;

    public ClassBodyVisitor(Scope scope, ClassDecl classDecl) {
        this.scope = scope;
        this.parent = classDecl;
    }

    @Override
    public Statement visitStatement(KaraffeParser.StatementContext ctx) {
        StatementVisitor visitor = new StatementVisitor(scope, parent);
        Statement statement = ctx.accept(visitor);
        return statement;
    }

    @Override
    public Statement visitFieldDecl(KaraffeParser.FieldDeclContext ctx) {
        FieldDeclVisitor visitor = new FieldDeclVisitor(scope, parent);
        FieldDecl fieldDecl = ctx.accept(visitor);
        return fieldDecl;
    }

    @Override
    public Statement visitCtorDecl(KaraffeParser.CtorDeclContext ctx) {
        CtorVisitor visitor = new CtorVisitor();
        FuncDecl funcDecl = ctx.accept(visitor);
        return funcDecl;
    }

}
