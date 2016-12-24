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
package org.karaffe.compiler.runner;

import java.io.IOException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.karaffe.compiler.antlr.KaraffeLexer;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.KaraffeFileIOException;
import org.karaffe.compiler.tree.CompileUnit;
import org.karaffe.compiler.visitors.CompileUnitVisitor;
import org.karaffe.compiler.visitors.SyntaxErrorListener;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
public class Parser {

    private final KaraffeFile file;

    public Parser(KaraffeFile file) {
        this.file = file;
    }

    public CompileUnit parse() {
        try {
            ANTLRFileStream fileStream = new ANTLRFileStream(file.getFileName());
            KaraffeLexer lexer = new KaraffeLexer(fileStream);
            KaraffeParser parser = new KaraffeParser(new BufferedTokenStream(lexer));
            CompileUnitVisitor visitor = new CompileUnitVisitor(file);
            CompileUnit compileUnit = parser.compileUnit().accept(visitor);
            parser.addErrorListener(new SyntaxErrorListener(file.getFileName()));
            return compileUnit;
        } catch (IOException ex) {
            throw new KaraffeFileIOException(ExceptionMessages.FILE_NOT_FOUND.additionalInfo(ex.getLocalizedMessage()));
        }
    }

    public KaraffeFile getFile() {
        return file;
    }

}
