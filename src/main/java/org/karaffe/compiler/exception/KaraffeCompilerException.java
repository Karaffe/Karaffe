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

import org.karaffe.compiler.Constants;

/**
 *
 * @author noko
 */
public class KaraffeCompilerException extends RuntimeException {

    private final ExceptionType type;
    private final ExceptionMessages message;
    private final String place;
    private final boolean isAvailableSourceCode;
    private final String sourceCode;
    private final int line;
    private final int column;
    private final boolean hasColumnEnd;
    private final int columnEnd;

    public KaraffeCompilerException(ExceptionType type, ExceptionMessages message) {
        this(type, message, null, false, null, -1, -1, false, -1);
    }

    public KaraffeCompilerException(ExceptionType type, ExceptionMessages message, String place, boolean isAvailableSourceCode, String sourceCode, int line, int column, boolean hasColumnEnd, int columnEnd) {
        super(message.toString());
        this.type = type;
        this.message = message;
        this.place = place;
        this.isAvailableSourceCode = isAvailableSourceCode;
        this.line = line;
        this.column = column;
        this.hasColumnEnd = hasColumnEnd;
        this.columnEnd = columnEnd;

        if (this.isAvailableSourceCode) {
            if (line == -1
                    || column == -1) {
                throw new IllegalArgumentException("line or column out of range. : " + line + " : " + column);
            }
        }
        if (this.hasColumnEnd) {
            if (this.columnEnd == -1) {
                throw new IllegalArgumentException("columnEnd -1");
            }
        }
        if (sourceCode == null) {
            this.sourceCode = null;
        } else if (sourceCode.contains(Constants.NEW_LINE)) {
            String[] sp = sourceCode.split(Constants.NEW_LINE);
            this.sourceCode = sp[0];
        } else {
            this.sourceCode = sourceCode;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(":").append(message);
        if (place != null) {
            sb.append(Constants.NEW_LINE).append(place);
            if (isAvailableSourceCode) {
                sb.append(" at ").append(line).append(":").append(column);
                if (this.hasColumnEnd) {
                    sb.append("~").append(columnEnd);
                }
                sb.append(Constants.NEW_LINE);
            }
            sb.append(sourceCode).append(Constants.NEW_LINE);
            for (int i = 0; i < column; i++) {
                sb.append(" ");
            }
            sb.append("^");
            if (this.hasColumnEnd) {
                for (int i = 0; i < columnEnd - column; i++) {
                    sb.append("~");
                }
            }
            sb.append(Constants.NEW_LINE);
        }

        return sb.toString();
    }

}
