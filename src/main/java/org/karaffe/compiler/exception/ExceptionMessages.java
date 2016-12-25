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

import java.util.ResourceBundle;

/**
 *
 * @author noko
 */
public enum ExceptionMessages {

    //Arguments
    EMPTY_ARG("compiler.arg.emptyargs"),
    BAD_ARG("compiler.arg.badargs"),
    //Naming
    CLASS_NAME_MUSTBE_PASCAL_CASE("compiler.err.classnaming.pascalcase"),
    //IO
    FILE_NOT_FOUND("compiler.io.file.notfound"),
    //Source
    SYNTAX_ERROR("compiler.err.syntax"),
    //Typing
    TYPE_NOT_FOUND("compiler.err.type.notfound"),
    TYPE_IS_NOT_INHERITABLE("compiler.err.type.notinheritable"),
    INNER_CLASS("compiler.err.innerclass"),;

    private final String messageKey;
    private String additionalInfo;

    private ExceptionMessages(String messageKey) {
        this.messageKey = messageKey;
    }

    public ExceptionMessages additionalInfo(String message) {
        ExceptionMessages.this.additionalInfo = message;
        return this;
    }

    @Override
    public String toString() {
        ResourceBundle rs = ResourceBundle.getBundle("compiler_msg");
        String message = rs.getString(messageKey);
        if (additionalInfo != null) {
            message = message.replace("{}", additionalInfo);
        }
        return message;
    }
}
