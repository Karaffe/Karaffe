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
import java.io.IOException;
import org.karaffe.compiler.exception.ExceptionMessages;
import org.karaffe.compiler.exception.KaraffeFileNotFoundException;
import org.karaffe.io.KaraffeFile;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.Messages;
import org.kohsuke.args4j.spi.OptionHandler;
import org.kohsuke.args4j.spi.Parameters;
import org.kohsuke.args4j.spi.Setter;

/**
 *
 * @author noko
 */
public class KaraffeFileHandler extends OptionHandler<KaraffeFile> {

    public KaraffeFileHandler(CmdLineParser parser, OptionDef option, Setter<? super KaraffeFile> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        String parameter = params.getParameter(0);
        if (!parameter.endsWith(".krf")) {
            return 1;
        }
        try {
            KaraffeFile file = new KaraffeFile(new File(parameter).toPath());
            setter.addValue(file);
        } catch (IOException e) {
            throw new KaraffeFileNotFoundException(ExceptionMessages.FILE_NOT_FOUND.additionalInfo(e.getLocalizedMessage()));
        }
        return 1;
    }

    @Override
    public String getDefaultMetaVariable() {
        return Messages.DEFAULT_META_STRING_ARRAY_OPTION_HANDLER.format();
    }

}
