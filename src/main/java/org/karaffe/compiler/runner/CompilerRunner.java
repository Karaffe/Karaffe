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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.karaffe.compiler.Constants;
import org.karaffe.compiler.antlr.KaraffeBaseListener;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.arg.CommandLineOptions;
import org.karaffe.compiler.arg.CommandLineParser;
import org.karaffe.stdlib.Either;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerRunner {

    private final String[] args;
    private final List<DebugModeListener> debugModeListeners = new ArrayList<>();
    private final List<VerboseModeListener> verboseModeListeners = new ArrayList<>();
    private final List<KaraffeBaseListener> parserListeners = new ArrayList<>();
    private final List<ANTLRErrorListener> errorListeners = new ArrayList<>();

    public CompilerRunner(String... args) {
        this.args = args;
    }

    public void addDebugModeListener(DebugModeListener listener) {
        this.debugModeListeners.add(listener);
    }

    public void addVerboseModeListener(VerboseModeListener listener) {
        this.verboseModeListeners.add(listener);
    }

    public void addParserListener(KaraffeBaseListener listener) {
        this.parserListeners.add(listener);
    }

    public void addErrorListener(ANTLRErrorListener listener) {
        this.errorListeners.add(listener);
    }

    public void run() {
        CommandLineParser cmdLineParser = new CommandLineParser(args);
        CommandLineOptions options = cmdLineParser.parse();

        if (options.isDebugMode()) {
            debugModeListeners.forEach(DebugModeListener::onDebugMode);
        } else if (options.isVerboseMode()) {
            verboseModeListeners.forEach(VerboseModeListener::onVerboseMode);
        }

        log.info("compiler initialized.");
        log.debug("args : " + Arrays.asList(args));
        log.debug("parsed options : " + options);

        if (options.hasVersion()) {
            log.debug("show version");
            System.out.println(Constants.VERSION_INFO_STRING);
            return;
        }

        options.getStream().forEach(f -> {
            Either<IOException, CharStream> charStreamEither = CharStreamFactory.createFromAbsolutePath(f.getAbsolutePath());
            charStreamEither.apply(
                    left -> {
                        log.error("IOError", left);
                    },
                    right -> {
                        TokenSource tokenSource = TokenSourceFactory.create(right);
                        TokenStream tokenStream = TokenStreamFactory.create(tokenSource);
                        KaraffeParser parser = new KaraffeParser(tokenStream);
                        parserListeners.forEach(parser::addParseListener);
                        errorListeners.forEach(parser::addErrorListener);
                        parser.compileUnit();
                    });
        });
    }
}
