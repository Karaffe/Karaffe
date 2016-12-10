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
package org.karaffe.compiler.arg;

import org.karaffe.compiler.Constants;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 *
 * @author noko
 */
public class CommandLineParser {

    private final String[] args;
    private final CmdLineParser parser;
    private final CommandLineOptions options;

    public CommandLineParser(String... args) {
        this.args = args;
        this.options = new CommandLineOptions();
        this.parser = new CmdLineParser(this.options);
    }

    public CommandLineOptions parse() {
        try {
            parser.parseArgument(args);
        } catch (CmdLineException ex) {
            System.out.println("bad option: ");
            System.out.println(ex.getMessage());
        }
        return options;
    }

    public void printUsage() {
        StringBuilder usage = new StringBuilder();
        usage.append("Karaffe Compiler ").append(Constants.VERSION).append(" (").append(System.getProperty("java.vm.name")).append(", ").append(System.getProperty("java.runtime.version")).append(")").append(Constants.NEW_LINE);
        usage.append("Usage: krfc <options> <source files|build.krf>").append(Constants.NEW_LINE);
        usage.append(Constants.NEW_LINE);
        usage.append("available options are ");
        System.out.println(usage.toString());
        parser.printUsage(System.out);
        System.err.println();
    }
}
