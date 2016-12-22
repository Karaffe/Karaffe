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

import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.karaffe.stdlib.Either;

/**
 *
 * @author noko
 */
public class CharStreamFactoryTest {

    @Test
    public void testCreate() throws IOException {
        File f = File.createTempFile("test", "krf", new File("."));
        Either<IOException, CharStream> charStream
                = CharStreamFactory.createFromAbsolutePath(f.getAbsolutePath());
        assertThat(charStream.isRight(), is(true));
        f.delete();
    }

    @Test
    public void testCreateFromFile() throws IOException {
        File f = File.createTempFile("test", "krf", new File("."));
        Either<IOException, CharStream> charStream
                = CharStreamFactory.createFromFile(f);
        assertThat(charStream.isRight(), is(true));
        f.delete();
    }

    @Test
    public void testCreateFromSource() {
        CharStream charStream = CharStreamFactory.createFromSource("class Hoge {}");
        assertThat(charStream, is(notNullValue()));
    }

}
