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
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.karaffe.compiler.tree.CompileUnit;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
public class ParserTest {

    @Test
    public void shouldCompiles() throws IOException {
        Stream<Path> pathList = Files
                .find(Paths.get("src", "test", "resources", "test-sources"), 10, (t, a) -> {
                    System.out.println(t.getFileName().toString() + " : " + t.getFileName().toString().endsWith("_pass.krf"));
                    return t.getFileName().toString().endsWith("_pass.krf");
                });
        long count = pathList
                .peek(p -> System.err.println("Compiling... : " + p))
                .map(p -> getCompileUnitFromSource(p))
                .peek(c -> System.err.println("Compiled. : " + c))
                .count();
        assertNotEquals(count, 0L);
    }

    private CompileUnit getCompileUnitFromSource(Path path) {
        try {
            KaraffeFile file = new KaraffeFile(path);
            Parser parser = new Parser(file);
            CompileUnit compileUnit = parser.parse();
            return compileUnit;
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
