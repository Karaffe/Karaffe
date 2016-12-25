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

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Function;
import static org.junit.Assert.*;
import org.junit.Test;
import org.karaffe.compiler.exception.CommandLineException;

/**
 *
 * @author noko
 */
public class ArgumentsParserTest {

    @Test(expected = CommandLineException.class)
    public void testEmptyArg() {
        ArgumentsParser parser = new ArgumentsParser();
        parser.parse();
    }

    @Test(expected = CommandLineException.class)
    public void testNullArg() {
        ArgumentsParser parser = new ArgumentsParser(null);
        parser.parse();
    }

    @Test
    public void testPrintUsage() throws IOException {
        File file = File.createTempFile("junit-test-", ".out");
        PrintStream printStream = new PrintStream(file);
        ArgumentsParser parser = new ArgumentsParser(printStream);
        parser.printUsage();
        List<String> outputs = Files.readAllLines(file.toPath());
        assertFalse(outputs.isEmpty());
        file.delete();
    }

    /**
     * Test of parse method, of class CommandLineParser.
     */
    @Test
    public void testParseVersionFlag() {
        checkFlagIsTrue(CompilerConfigurations::hasVersion, "--version");
        checkFlagIsTrue(CompilerConfigurations::hasVersion, "-version");
    }

    @Test
    public void testParseDebugModeFlag() {
        checkFlagIsTrue(CompilerConfigurations::isDebugMode, "--debug");
        checkFlagIsTrue(CompilerConfigurations::isDebugMode, "-vv");
    }

    @Test
    public void testParseVerboseMode() {
        checkFlagIsTrue(CompilerConfigurations::isVerboseMode, "-v");
        checkFlagIsTrue(CompilerConfigurations::isVerboseMode, "--verbose");
    }

    @Test
    public void testParseParallelMode() {
        checkFlagIsTrue(CompilerConfigurations::isParallelMode, "--parallel");
    }

    @Test
    public void testParseLogOutputMode() {
        checkFlagIsTrue(CompilerConfigurations::hasLogOutputFile, "--log-output", "hoge");
    }

    @Test(expected = CommandLineException.class)
    public void testParseFail1() {
        checkArgs("-dddd");
    }

    private CompilerConfigurations checkArgs(String... args) {
        ArgumentsParser parser = new ArgumentsParser(args);
        CompilerConfigurations config = parser.parse();
        return config;
    }

    private void checkFlagIsTrue(Function<CompilerConfigurations, Boolean> function, String... options) {
        ArgumentsParser instance = new ArgumentsParser(options);
        CompilerConfigurations parsed = instance.parse();
        Boolean result = function.apply(parsed);
        assertTrue(result);
    }

}
