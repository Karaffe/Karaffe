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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.arg.ArgumentsParser;
import org.karaffe.compiler.arg.CompilerConfigurations;
import org.karaffe.compiler.exception.CommandLineException;
import org.karaffe.compiler.exception.KaraffeCompilerException;
import org.karaffe.compiler.runner.CompilerRunner;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {

    public static void main(String... args) {
        try {
            ArgumentsParser parser = new ArgumentsParser(args);
            CompilerConfigurations config = parser.parse();

            if (config.hasVersion()) {
                System.out.println(Constants.VERSION_INFO_STRING);
                if (config.isDebugLogMode() || config.isInfoLogMode()) {
                    System.out.println(Constants.VERSION_INFO_STRING_DEBUG);
                }
                System.exit(ExitStatus.EX_OK.toInt());
            }

            Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
            if (config.hasLogOutputFile()) {
                System.setOut(config.getLogStream());
                System.setErr(config.getLogStream());
            }

            if (config.isErrorLogMode()) {
                rootLogger.setLevel(Level.ERROR);
            } else if (config.isWarnLogMode()) {
                rootLogger.setLevel(Level.WARN);
            } else if (config.isInfoLogMode()) {
                rootLogger.setLevel(Level.INFO);
            } else if (config.isDebugLogMode()) {
                rootLogger.setLevel(Level.DEBUG);
            } else {
                rootLogger.setLevel(Level.OFF);
            }

            log.info("start compiler");
            CompilerRunner runner = new CompilerRunner(config);
            ExitStatus exitStatus = runner.run();
            log.info("end compiler : " + exitStatus);
            System.exit(exitStatus.toInt());
        } catch (CommandLineException e) {
            System.err.println(e);
            e.getParser().printUsage();
            System.exit(-1);
        } catch (KaraffeCompilerException e) {
            System.err.println(e);
            System.exit(-1);
        } catch (Exception e) {
            System.err.println("Compiler internal error : " + e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
