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

/**
 *
 * @author noko
 */
public enum ExitStatus {

    EX_OK("successful termination", 0),
    EX_USAGE("command line usage error", 64),
    EX_DATAERR("data format error", 65),
    EX_NOINPUT("cannot open input", 66),
    EX_NOUSER("addressee unknown", 67),
    EX_NOHOST("host name unknown", 68),
    EX_UNAVAILABLE("service unavailable", 69),
    EX_SOFTWARE("internal software error", 70),
    EX_OSERR("system error (e.g., can't fork)", 71),
    EX_OSFILE("critical OS file missing", 72),
    EX_CANTCREAT("can't create (user) output file", 73),
    EX_IOERR("input/output error", 74),
    EX_TEMPFAIL("temp failure; user is invited to retry", 75),
    EX_PROTOCOL("remote error in protocol", 76),
    EX_NOPERM("permission denied", 77),
    EX_CONFIG("configuration error", 78),;
    private final String message;
    private final int exitCode;

    private ExitStatus(String message, int exitCode) {
        this.message = message;
        this.exitCode = exitCode;
    }

    public int toInt() {
        return exitCode;
    }

    @Override
    public String toString() {
        return exitCode + " = " + message;
    }

}
