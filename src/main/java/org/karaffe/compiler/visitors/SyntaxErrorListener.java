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

import java.util.BitSet;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;
import org.karaffe.compiler.Constants;
import org.karaffe.compiler.antlr.KaraffeLexer;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.ExceptionType;
import org.karaffe.compiler.exception.SyntaxErrorException;

/**
 *
 * @author noko
 */
@Slf4j
public class SyntaxErrorListener extends BaseErrorListener {

    private final String fileName;

    public SyntaxErrorListener() {
        this("unknown file");
    }

    public SyntaxErrorListener(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String string, RecognitionException re) {
        log.error("syntax error detected. on syntaxError");
        if (recognizer instanceof KaraffeParser) {
            onParserError((KaraffeParser) recognizer, (CommonToken) o, i1, i1, string);
        } else if (recognizer instanceof KaraffeLexer) {
            onLexerError((KaraffeLexer) recognizer, i, i1, string);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void onParserError(KaraffeParser parser, CommonToken token, int line, int charIndex, String errorComment) {
        log.error("on parser error");
        if (token != null) {
            throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR, token);
        } else {
            throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR);
        }
    }

    private void onLexerError(KaraffeLexer lexer, int line, int column, String string) {
        log.error("on lexer error");
        log.debug("lexer       : {}", lexer);
        log.debug("line        : {}", line);
        log.debug("column      : {}", column);
        log.debug("msg         : {}", string);
        CharStream charStream = lexer.getInputStream();
        String sourceName = charStream.getSourceName();
        String sourceCode = charStream.getText(Interval.of(0, charStream.size()));

        String[] lines = sourceCode.split(Constants.NEW_LINE);
        String lineSourceCode = lines[line - 1];
        throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR, sourceName, lineSourceCode, line, column);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        log.error("syntax error detected. on reportAmbiguity");
        throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR);
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        log.error("syntax error detected. on reportAttemptingFullContext");
        throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR);
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        log.error("syntax error detected. on reportContextSensitivity");
        throw new SyntaxErrorException(ExceptionType.ERROR, ExceptionMessages.SYNTAX_ERROR);
    }

}
