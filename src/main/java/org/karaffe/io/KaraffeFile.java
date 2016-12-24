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
package org.karaffe.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.KaraffeFileNotFoundException;

/**
 *
 * @author noko
 */
public class KaraffeFile {

    private final Path filePath;
    private final List<String> source;

    public KaraffeFile(Path filePath) throws IOException {
        this.filePath = filePath;
        this.source = Files.readAllLines(filePath);
    }

    public static KaraffeFile of(Path path) {
        try {
            return new KaraffeFile(path);
        } catch (IOException e) {
            throw new KaraffeFileNotFoundException(ExceptionMessages.FILE_NOT_FOUND.additionalInfo(e.getMessage()));
        }
    }

    public Path getFilePath() {
        return filePath;
    }

    public List<String> getSource() {
        return source;
    }

    public String getFileName() {
        return filePath.toAbsolutePath().toString();
    }

    public String getLine(int index) {
        if (index <= 0 || index >= source.size()) {
            throw new IllegalArgumentException("out of range : " + index);
        }
        return source.get(index - 1);
    }

}
