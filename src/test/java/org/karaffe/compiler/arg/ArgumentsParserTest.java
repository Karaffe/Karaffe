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

import java.util.function.Function;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author noko
 */
public class ArgumentsParserTest {

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

    @Test
    public void testParseFail1() {
        checkFlagIsTrue(c -> {
            return c.isArgumentsError();
        }, "-ddddd");
        checkFlagIsTrue(c -> {
            assert !c.getReports().isEmpty() : "error is not reported";
            return true;
        }, "-ddddd");
    }

    private void checkFlagIsTrue(Function<CompilerConfigurations, Boolean> function, String... options) {
        ArgumentsParser instance = new ArgumentsParser(options);
        CompilerConfigurations parsed = instance.parse();
        Boolean result = function.apply(parsed);
        assertTrue(result);
    }

}
