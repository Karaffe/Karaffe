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
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.NamingException;

/**
 *
 * @author noko
 */
@Slf4j
public class VarNameVisitor extends KaraffeBaseVisitor<String> {

    @Override
    public String visitMethodName(KaraffeParser.MethodNameContext ctx) {
        log.info("visitMethodName start");
        String methodName = ctx.getText();
        log.debug("methodName : {}", methodName);
        if (Character.isUpperCase(methodName.charAt(0))) {
            throw new NamingException(ExceptionMessages.MUSTBE_CAMEL_CASE, ctx.getParent(), ctx);
        }
        log.info("visitMethodName end");
        return methodName;
    }

    @Override
    public String visitFieldName(KaraffeParser.FieldNameContext ctx) {
        log.info("visitFieldName start");
        String fieldName = ctx.getText();
        log.debug("fieldName : {}", fieldName);
        if (Character.isUpperCase(fieldName.charAt(0))) {
            throw new NamingException(ExceptionMessages.MUSTBE_CAMEL_CASE, ctx.getParent(), ctx);
        }
        log.info("visitFieldName end");
        return fieldName;
    }

    @Override
    public String visitParameterName(KaraffeParser.ParameterNameContext ctx) {
        log.info("visitParameterName start");
        String paramName = ctx.getText();
        log.debug("paramName : {}", paramName);
        if (Character.isUpperCase(paramName.charAt(0))) {
            throw new NamingException(ExceptionMessages.MUSTBE_CAMEL_CASE, ctx.getParent(), ctx);
        }
        log.info("visitParameterName end");
        return paramName;
    }

}
