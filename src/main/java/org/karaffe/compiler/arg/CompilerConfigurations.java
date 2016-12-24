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
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.io.KaraffeFile;
import org.karaffe.io.KaraffeFileStream;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

/**
 *
 * @author noko
 */
@Slf4j
public class CompilerConfigurations implements KaraffeFileStream {

    @Option(name = "--version", aliases = "-version", usage = "Show compiler version")
    private boolean hasVersion;

    @Option(name = "-vv", aliases = "--debug", usage = "log in debug mode")
    private boolean isDebugMode;

    @Option(name = "-v", aliases = "--verbose", usage = "log in verbose mode")
    private boolean isVerboseMode;

    @Option(name = "--parallel", usage = "build in parallel")
    private boolean isParallelMode;

    @Option(name = "--log-output", usage = "log message to FILE")
    private File logFile;

    private boolean isArgumentsError;

    @Argument(handler = KaraffeFileHandler.class, multiValued = true)
    private List<KaraffeFile> sourceFiles = new ArrayList<>();

    public boolean hasVersion() {
        return hasVersion;
    }

    public boolean isDebugMode() {
        return isDebugMode;
    }

    public boolean isVerboseMode() {
        return isVerboseMode;
    }

    public boolean isParallelMode() {
        return isParallelMode;
    }

    @Override
    public boolean hasFile() {
        return !sourceFiles.isEmpty();
    }

    public boolean hasLogOutputFile() {
        return logFile != null;
    }

    public File getLogFile() {
        return logFile;
    }

    public PrintStream getLogStream() {
        try {
            return new PrintStream(logFile);
        } catch (FileNotFoundException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public Stream<KaraffeFile> getFileStream() {
        return sourceFiles.stream();
    }

    public Stream<KaraffeFile> getFileParallelStream() {
        return sourceFiles.parallelStream();
    }

    public void setArgumentsError() {
        this.isArgumentsError = true;
    }

    public boolean isArgumentsError() {
        return isArgumentsError;
    }

    @Override
    public String toString() {
        return "CompilerConfigurations{" + "hasVersion=" + hasVersion + ", isDebugMode=" + isDebugMode + ", isVerboseMode=" + isVerboseMode + ", isParallelMode=" + isParallelMode + ", logFile=" + logFile + ", isArgumentsError=" + isArgumentsError + ", sourceFiles=" + sourceFiles + '}';
    }

    @Override
    public boolean isEmpty() {
        return sourceFiles.isEmpty();
    }

}
