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
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.karaffe.compiler.ExitStatus;
import org.karaffe.io.KaraffeFileStream;

/**
 *
 * @author noko
 */
public class CompilerRunnerTest {

    @Test
    public void testRun() {
        CompilerRunner runner = new CompilerRunner();
        ExitStatus exitStatus = runner.run();
        assertThat(exitStatus, is(ExitStatus.EX_IOERR));
    }

    @Test
    public void testRun2() throws IOException {
        File f = File.createTempFile("karaffe-junit-", ".krf");
        KaraffeFileStream fileStream = KaraffeFileStream.of(f);
        CompilerRunner runner = new CompilerRunner(fileStream);
        ExitStatus exitStatus = runner.run();
        assertThat(exitStatus, is(ExitStatus.EX_OK));
        f.delete();
    }
}
