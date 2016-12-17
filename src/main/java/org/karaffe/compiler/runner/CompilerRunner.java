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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.TokenStream;
import org.karaffe.compiler.Constants;
import org.karaffe.compiler.antlr.KaraffeLexer;
import org.karaffe.compiler.antlr.KaraffeParser;
import org.karaffe.compiler.arg.CommandLineOptions;
import org.karaffe.compiler.arg.CommandLineParser;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.tree.ClassDecl;
import org.karaffe.compiler.visitors.ClassDeclListener;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.slf4j.LoggerFactory;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerRunner {

    public void run(String... args) {
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

        log.info("compiler initialized.");
        log.debug("args : " + Arrays.asList(args));
        log.debug("parsed options : " + options);

        if (options.hasVersion()) {
            log.debug("show version");
            cmdLineParser.printUsage();
            return;
        }

        options.getStream().forEach(f -> {
            try {
                KaraffeParser parser = newParser(newTokenStream(newTokenSource(newCharStream(f.getAbsolutePath()))));
                ClassDeclListener classDeclListener = new ClassDeclListener();
                parser.addParseListener(classDeclListener);
                parser.compileUnit();
                List<ClassDecl> classDecls = classDeclListener.getDeclaredClasses();
                List<Report> reports = classDeclListener.getReports();
                printReports(f.getName(), Files.readAllLines(f.toPath()), reports);
                writeClassDeclsToClassFile(classDecls);
            } catch (IOException e) {
                log.error("IO Error", e);
            }
        });
    }

    private CharStream newCharStream(String absolutePath) throws IOException {
        return new ANTLRFileStream(absolutePath);
    }

    private TokenSource newTokenSource(CharStream charStream) {
        return new KaraffeLexer(charStream);
    }

    private TokenStream newTokenStream(TokenSource source) {
        return new BufferedTokenStream(source);
    }

    private KaraffeParser newParser(TokenStream input) {
        KaraffeParser parser = new KaraffeParser(input);
        parser.removeErrorListeners();
        parser.removeParseListeners();
        return parser;
    }

    private void printReports(String fileName, List<String> sources, List<Report> reports) {
        reports.forEach(r -> {
            System.out.println(r.getType() + ": " + r.getTitle() + Constants.NEW_LINE + fileName + " at " + r.getLine() + ":" + r.getColumn() + "~" + r.getEndColumn());
            String line = sources.get(r.getLine() - 1);
            System.out.println(line);
            for (int i = 0; i < r.getColumn(); i++) {
                System.out.print(' ');
            }
            System.out.print('^');
            for (int i = 0; i < r.getEndColumn() - r.getColumn(); i++) {
                System.out.print('~');
            }
            System.out.println();
        });
    }

    private void writeClassDeclsToClassFile(List<ClassDecl> classDecls) {
        classDecls
                .stream()
                .map(c -> convert(c))
                .forEach(c -> {
                    ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
                    c.accept(writer);
                    byte[] byteCode = writer.toByteArray();
                    try {
                        Files.write(new File(c.name + ".class").toPath(), byteCode);
                    } catch (IOException ex) {
                        log.error("IOError", ex);
                    }
                });
    }

    private ClassNode convert(ClassDecl classDecl) {
        ClassNode classNode = new ClassNode();
        classNode.name = classDecl.getName();
        classNode.version = Opcodes.V1_8;
        classNode.sourceFile = classDecl.getName() + ".krf";
        return classNode;
    }
}
