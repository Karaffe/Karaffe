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

import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
public class CompilerConfigurationsTest {

    /**
     * Test of hasVersion method, of class CompilerConfigurations.
     */
    @Test
    public void testHasVersion() {
        ArgumentsParser parser = new ArgumentsParser("-version");
        CompilerConfigurations config = parser.parse();
        assertTrue(config.hasVersion());
        assertFalse(config.isArgumentsError());
        assertFalse(config.hasLogOutputFile());
        assertFalse(config.hasFile());
        assertFalse(config.isDebugMode());
        assertTrue(config.isEmpty());
        assertFalse(config.isParallelMode());
        assertFalse(config.isVerboseMode());
        Stream<KaraffeFile> stream = config.getFileStream();
        assertThat(stream.count(), is(0L));
        Stream<KaraffeFile> parallelStream = config.getFileParallelStream();
        assertThat(parallelStream.count(), is(0L));
    }

    @Test
    public void testHasVersion2() {
        ArgumentsParser parser = new ArgumentsParser("--version");
        CompilerConfigurations config = parser.parse();
        assertTrue(config.hasVersion());
        assertFalse(config.isArgumentsError());
        assertFalse(config.hasLogOutputFile());
        assertFalse(config.hasFile());
        assertFalse(config.isDebugMode());
        assertTrue(config.isEmpty());
        assertFalse(config.isParallelMode());
        assertFalse(config.isVerboseMode());
        Stream<KaraffeFile> stream = config.getFileStream();
        assertThat(stream.count(), is(0L));
        Stream<KaraffeFile> parallelStream = config.getFileParallelStream();
        assertThat(parallelStream.count(), is(0L));
    }

    @Test
    public void testIsDebugMode() {
        ArgumentsParser parser = new ArgumentsParser("-vv");
        CompilerConfigurations config = parser.parse();
        assertFalse(config.hasVersion());
        assertFalse(config.isArgumentsError());
        assertFalse(config.hasLogOutputFile());
        assertFalse(config.hasFile());
        assertTrue(config.isDebugMode());
        assertTrue(config.isEmpty());
        assertFalse(config.isParallelMode());
        assertFalse(config.isVerboseMode());
        Stream<KaraffeFile> stream = config.getFileStream();
        assertThat(stream.count(), is(0L));
        Stream<KaraffeFile> parallelStream = config.getFileParallelStream();
        assertThat(parallelStream.count(), is(0L));
    }

    @Test
    public void testIsDebugMode2(){
        ArgumentsParser parser = new ArgumentsParser("--debug");
        CompilerConfigurations config = parser.parse();
        assertFalse(config.hasVersion());
        assertFalse(config.isArgumentsError());
        assertFalse(config.hasLogOutputFile());
        assertFalse(config.hasFile());
        assertTrue(config.isDebugMode());
        assertTrue(config.isEmpty());
        assertFalse(config.isParallelMode());
        assertFalse(config.isVerboseMode());
        Stream<KaraffeFile> stream = config.getFileStream();
        assertThat(stream.count(), is(0L));
        Stream<KaraffeFile> parallelStream = config.getFileParallelStream();
        assertThat(parallelStream.count(), is(0L));
    }

}
