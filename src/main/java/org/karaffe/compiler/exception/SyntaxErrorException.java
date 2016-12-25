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
package org.karaffe.compiler.exception;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

/**
 *
 * @author noko
 */
public class SyntaxErrorException extends SourceCodeException {

    public SyntaxErrorException(ExceptionType type, ExceptionMessages message) {
        super(type, message);
    }

    public SyntaxErrorException(ExceptionType type, ExceptionMessages message, ParserRuleContext context, ParserRuleContext errorContext) {
        super(type, message, context, errorContext);
    }

    public SyntaxErrorException(ExceptionType type, ExceptionMessages message, CommonToken token) {
        super(
                type,
                message,
                token.getTokenSource().getSourceName(),
                true,
                token.getInputStream().getText(new Interval(token.getStartIndex(), token.getStopIndex())),
                token.getLine(),
                token.getCharPositionInLine(),
                false,
                -1);
    }

    public SyntaxErrorException(ExceptionType type, ExceptionMessages message, String sourceName, String lineSourceCode, int line, int charIndex) {
        super(
                type,
                message,
                sourceName,
                true,
                lineSourceCode,
                line,
                charIndex,
                false,
                -1);
    }

}
