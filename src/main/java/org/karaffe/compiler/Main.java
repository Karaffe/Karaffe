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
package org.karaffe.compiler;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.karaffe.compiler.antlr.KaraffeLexer;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.arg.CommandLineOptions;
import org.karaffe.compiler.arg.CommandLineParser;
import org.karaffe.compiler.visitors.ClassDeclListener;
import org.slf4j.LoggerFactory;

public class Main {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        CommandLineParser cmdLineParser = new CommandLineParser(args);
        if (args.length == 0) {
            cmdLineParser.printUsage();
            return;
        }
        CommandLineOptions options = cmdLineParser.parse();

        Logger root = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        if (options.isDebugMode()) {
            root.setLevel(Level.ALL);
        } else if (options.isVerboseMode()) {
            root.setLevel(Level.INFO);
        }

        LOGGER.info("compiler initialized.");
        LOGGER.debug("args : " + Arrays.asList(args));
        LOGGER.debug("parsed options : " + options);

        if (options.hasVersion()) {
            LOGGER.debug("show version");
            cmdLineParser.printUsage();
            return;
        }

        if (options.isParallelMode()) {
            options.parallelEachFile(Main::compileFile);
        } else {
            options.eachFile(Main::compileFile);
        }
    }

    private static void compileFile(File f) {
        try {
            ANTLRFileStream antlrfs = new ANTLRFileStream(f.getAbsolutePath());
            KaraffeLexer lexer = new KaraffeLexer(antlrfs);
            KaraffeParser parser = new KaraffeParser(new BufferedTokenStream(lexer));
            parser.removeErrorListeners();
            parser.removeParseListeners();
            parser.addParseListener(new ClassDeclListener());
            parser.compileUnit();
        } catch (IOException e) {
            LOGGER.error("file not found.", e);
        }
    }

}
