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
import org.karaffe.compiler.tree.Expression;
import org.karaffe.compiler.tree.FuncDecl;
import org.karaffe.compiler.tree.ImportDecl;
import org.karaffe.compiler.tree.InterfaceDecl;
import org.karaffe.compiler.tree.PackageDecl;
import org.karaffe.compiler.tree.Statement;
import org.karaffe.compiler.tree.meta.Scope;

/**
 *
 * @author noko
 */
@Slf4j
public class StatementVisitor extends KaraffeBaseVisitor<Statement> {

    private final Scope scope;
    private final Statement parent;

    public StatementVisitor(Scope scope) {
        this.scope = scope;
        this.parent = null;
    }

    public StatementVisitor(Scope scope, Statement parent) {
        this.scope = scope;
        this.parent = parent;
    }

    @Override
    public Statement visitPackageDecl(KaraffeParser.PackageDeclContext ctx) {
        PackageDeclVisitor visitor = new PackageDeclVisitor(scope, parent);
        PackageDecl packageDecl = ctx.accept(visitor);
        return packageDecl;
    }

    @Override
    public Statement visitImportDecl(KaraffeParser.ImportDeclContext ctx) {
        ImportDeclVisitor visitor = new ImportDeclVisitor(parent);
        ImportDecl importDecl = ctx.accept(visitor);
        return importDecl;
    }

    @Override
    public Statement visitInterfaceDecl(KaraffeParser.InterfaceDeclContext ctx) {
        InterfaceDeclVisitor visitor = new InterfaceDeclVisitor(parent);
        InterfaceDecl interfaceDecl = ctx.accept(visitor);
        return interfaceDecl;
    }

    @Override
    public Statement visitFuncDecl(KaraffeParser.FuncDeclContext ctx) {
        FuncDeclVisitor visitor = new FuncDeclVisitor(parent);
        FuncDecl funcDecl = ctx.accept(visitor);
        return funcDecl;
    }

    @Override
    public Statement visitClassDecl(KaraffeParser.ClassDeclContext ctx) {
        ClassDeclVisitor visitor = new ClassDeclVisitor(scope, (ClassDecl) parent);
        ClassDecl classDecl = ctx.accept(visitor);
        return classDecl;
    }

    @Override
    public Statement visitExpr(KaraffeParser.ExprContext ctx) {
        ExpressionVisitor visitor = new ExpressionVisitor();
        Expression expression = ctx.accept(visitor);
        return expression;
    }

}
