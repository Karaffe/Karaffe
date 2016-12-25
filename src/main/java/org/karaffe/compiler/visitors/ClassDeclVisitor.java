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
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.tree.Statement;
import org.karaffe.compiler.tree.meta.ClassMetaData;
import org.karaffe.compiler.tree.meta.Scope;
import org.karaffe.compiler.type.JavaType;

/**
 *
 * @author noko
 */
@Slf4j
public class ClassDeclVisitor extends KaraffeBaseVisitor<ClassDecl> {

    private final Scope scope;
    private final ClassDecl parent;

    public ClassDeclVisitor(Scope scope) {
        this.scope = scope;
        this.parent = null;
    }

    public ClassDeclVisitor(Scope scope, ClassDecl parent) {
        this.scope = scope;
        this.parent = parent;
    }

    @Override
    public ClassDecl visitClassDecl(KaraffeParser.ClassDeclContext classDeclContext) {
        log.info("enter class decl");
        String className = classDeclContext.className().accept(new ClassNameVisitor());
        ClassMetaData currentMetaData;
        if (classDeclContext.superOrInterfaceList() == null) {
            currentMetaData = ClassMetaData.builder().superClass(JavaType.ANY_TYPE).outerClass(parent).build();
        } else {
            currentMetaData = classDeclContext.superOrInterfaceList().accept(new SuperOrInterfaceVisitor(scope, parent));
        }

        ClassDecl classDecl = new ClassDecl(currentMetaData, className);
        if (classDeclContext.classBodyBlock() != null) {
            List<KaraffeParser.ClassBodyContext> classBodyContexts = classDeclContext.classBodyBlock().classBody();
            for (KaraffeParser.ClassBodyContext bodyContext : classBodyContexts) {
                Statement statement = bodyContext.accept(new ClassBodyVisitor(scope, classDecl));
                classDecl.addStatement(statement);
            }
        }

        if (classDecl.isNeedDefaultConstructor()) {
            //Make default constructor
        }

        log.info("end class decl");
        return classDecl;
    }

}
