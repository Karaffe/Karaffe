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

import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.NamingException;
import org.karaffe.compiler.tree.ClassDecl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author noko
 */
public class ClassDeclVisitor extends KaraffeBaseVisitor<ClassDecl> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassDeclVisitor.class);

    @Override
    public ClassDecl visitClassDecl(KaraffeParser.ClassDeclContext classDeclContext) {
        LOGGER.info("enter class decl");
        KaraffeParser.ClassNameContext classNameContext = classDeclContext.className();
        String className = classNameContext.getText();
        LOGGER.debug("className : " + className);
        ClassDecl classDecl = new ClassDecl(className);
        if (Character.isLowerCase(className.charAt(0))) {
            throw new NamingException(ExceptionMessages.CLASS_NAME_MUSTBE_PASCAL_CASE, classDeclContext);
        }
        KaraffeParser.ClassBodyBlockContext classBodyBlock = classDeclContext.classBodyBlock();
        return classDecl;
    }

}
