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
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.karaffe.compiler.arg.ArgumentsParser;
import org.karaffe.compiler.arg.CompilerConfigurations;
import org.karaffe.compiler.report.Report;
import org.karaffe.compiler.report.ReportType;
import org.karaffe.compiler.report.ReportWriter;
import org.karaffe.compiler.runner.CompilerRunner;
import org.slf4j.LoggerFactory;

@Slf4j
public class Main {

    public static void main(String... args) {
        ArgumentsParser parser = new ArgumentsParser(args);
        CompilerConfigurations config = parser.parse();

        if (config.hasVersion()) {
            parser.printUsage();
            System.exit(ExitStatus.EX_OK.toInt());
        }

        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        if (config.hasLogOutputFile()) {
            LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
            loggerContext.reset();
            PatternLayoutEncoder encoder = new PatternLayoutEncoder();
            encoder.setContext(loggerContext);
            encoder.setPattern("%d{HH:mm:ss.SSS} [%-36thread] %-5level %logger{36} --- %msg%n");
            encoder.start();

            FileAppender<ILoggingEvent> fileAppender = new FileAppender<>();
            fileAppender.setFile(config.getLogFile().getAbsolutePath());
            fileAppender.setContext(loggerContext);
            fileAppender.setEncoder(encoder);
            fileAppender.setAppend(true);
            fileAppender.start();
            rootLogger.addAppender(fileAppender);
        }

        if (config.isVerboseMode()) {
            rootLogger.setLevel(Level.INFO);
        } else if (config.isDebugMode()) {
            rootLogger.setLevel(Level.ALL);
        } else {
            rootLogger.setLevel(Level.OFF);
        }

        log.info("start compiler");
        ReportWriter argReportWriter = new ReportWriter();
        List<Report> reports = config.getReports();
        if (config.isArgumentsError()) {
            reports.addAll(parser.getReports());
            reports.addAll(config.getReports());
            Report report = Report.builder().title("arg error").type(ReportType.ERROR).place("").hasLineInfo(false).build();
            reports.add(report);
            argReportWriter.printReport(reports);
            System.exit(ExitStatus.EX_USAGE.toInt());
        }
        if (!reports.isEmpty()) {
            argReportWriter.printReport(reports);
            parser.printUsage();
            System.exit(ExitStatus.EX_USAGE.toInt());
        }
        CompilerRunner runner = new CompilerRunner(config);
        ExitStatus exitStatus = runner.run();
        log.info("end compiler : " + exitStatus);
        System.exit(exitStatus.toInt());
    }
}
