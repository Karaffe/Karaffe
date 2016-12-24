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
import org.antlr.v4.runtime.tree.RuleNode;
import org.karaffe.compiler.antlr.KaraffeBaseVisitor;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.NamingException;

/**
 *
 * @author noko
 */
@Slf4j
public class ClassNameVisitor extends KaraffeBaseVisitor<String> {

    @Override
    public String visitClassName(KaraffeParser.ClassNameContext ctx) {
        log.info("enter class name");
        String className = ctx.getText();
        log.info("className : " + className);
        if (Character.isLowerCase(className.charAt(0))) {
            throw new NamingException(ExceptionMessages.CLASS_NAME_MUSTBE_PASCAL_CASE, ctx.getParent());
        }
        log.info("end class name");
        return className;
    }

    @Override
    public String visitChildren(RuleNode node) {
        return super.visitChildren(node); //To change body of generated methods, choose Tools | Templates.
    }


}
