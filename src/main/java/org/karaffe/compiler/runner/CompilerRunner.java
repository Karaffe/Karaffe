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

import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.ExitStatus;
import org.karaffe.compiler.arg.CompilerConfigurations;
import org.karaffe.compiler.tree.CompileUnit;
import org.karaffe.io.ClassFileWriter;
import org.karaffe.io.KaraffeFile;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerRunner {

    private final CompilerConfigurations config;

    public CompilerRunner(CompilerConfigurations config) {
        this.config = config;
    }

    public ExitStatus run() {
        if (config.isEmpty()) {
            log.error("Empty filestream. report IOERR");
            return ExitStatus.EX_IOERR;
        }
        Stream<KaraffeFile> fileStream;
        if (config.isParallelMode()) {
            log.debug("use parallel stream");
            fileStream = config.getFileParallelStream();
        } else {
            log.debug("use sequential stream");
            fileStream = config.getFileStream();
        }
        log.debug("compiling... ");
        Stream<CompileUnit> compileUnitStream = fileStream.map(ParserRunner::new)
                .map(ParserRunner::parse)
                .peek(c -> log.debug("parse finished : {}", c));
        if (config.isCompileOnly()) {
            compileUnitStream.count();
            log.debug("dry-run mode");
            return ExitStatus.EX_OK;
        }

        compileUnitStream.map(ClassFileWriter::new)
                .peek(w -> log.debug("class writer initialized. : {}", w))
                .forEach(ClassFileWriter::writeClassDeclsToClassFile);
        return ExitStatus.EX_OK;
    }

}
