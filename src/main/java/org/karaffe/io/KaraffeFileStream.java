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

import fj.data.Either;
import java.io.File;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import org.karaffe.io.KaraffeFile;

public interface KaraffeFileStream {

    Stream<KaraffeFile> getFileStream();

    default boolean hasFile() {
        return !isEmpty();
    }

    default boolean isEmpty() {
        return getFileStream().count() == 0;
    }

    public static KaraffeFileStream of(String... filePaths) {
        List<File> fileList = Stream.of(filePaths).map(File::new).collect(toList());
        return KaraffeFileStream.of(fileList.toArray(new File[filePaths.length]));
    }

    public static KaraffeFileStream of(File... files) {
        List<KaraffeFile> f = Stream
                .of(files)
                .map(File::toPath)
                .map(KaraffeFile::of)
                .map(either -> {
                    return either.bimap(left -> {
                        return null;
                    }, right -> right);
                })
                .filter(Either::isRight)
                .map(e -> e.right().value())
                .collect(toList());
        return new LocalFileStream(f);
    }

    public static KaraffeFileStream emptyStream() {
        return new EmptyStream();
    }

}
