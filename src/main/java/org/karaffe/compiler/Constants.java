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
package org.karaffe.compiler;

import java.util.Optional;

/**
 *
 * @author noko
 */
public enum Constants {
    INSTANCE,;
    public static final String VERSION = "0.1";
    public static final String NEW_LINE = System.lineSeparator();
    public static final String VERSION_INFO_STRING;
    public static final String VERSION_INFO_STRING_DEBUG;
    public static final String CURRENT_CLASSPATH;
    public static final String JAVA_HOME;

    static {
        StringBuilder versionInfo = new StringBuilder();
        versionInfo.append("Karaffe Compiler ").append(Constants.VERSION).append(" (").append(System.getProperty("java.vm.name")).append(", ").append(System.getProperty("java.runtime.version")).append(")").append(Constants.NEW_LINE);
        versionInfo.append("Usage: krfc <options> <source files|build.krf>").append(Constants.NEW_LINE);
        VERSION_INFO_STRING = versionInfo.toString();

        CURRENT_CLASSPATH = System.getProperty("java.class.path");
        JAVA_HOME = Optional.ofNullable(System.getenv("JAVA_HOME")).orElseGet(() -> System.getProperty("java.home"));
        VERSION_INFO_STRING_DEBUG = String.format("CLASSPATH:%s%nJAVA_HOME:%s%n", CURRENT_CLASSPATH, JAVA_HOME);
    }
}
