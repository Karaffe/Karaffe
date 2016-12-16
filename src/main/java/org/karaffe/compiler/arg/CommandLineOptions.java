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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author noko
 */
public class CommandLineOptions {

    @Option(name = "--version", aliases = "-version", usage = "Show compiler version")
    private boolean hasVersion;

    @Option(name = "-vv", aliases = "--debug", usage = "log in debug mode")
    private boolean isDebugMode;

    @Option(name = "-v", aliases = "--verbose", usage = "log in verbose mode")
    private boolean isVerboseMode;

    @Option(name = "--parallel", usage = "build in parallel")
    private boolean isParallelMode;

    @Argument
    private List<File> sourceFiles = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineOptions.class);

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

    public void eachFile(Consumer<File> consumer) {
        LOGGER.info("start");
        sourceFiles.forEach(consumer);
        LOGGER.info("finished");
    }

    @Override
    public String toString() {
        return "CommandLineOptions{"
                + "hasVersion="
                + hasVersion
                + ", isDebugMode="
                + isDebugMode
                + ", isVerboseMode="
                + isVerboseMode
                + ", isParallelMode="
                + isParallelMode
                + ", sourceFiles="
                + sourceFiles + '}';
    }

}
