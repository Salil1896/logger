package com.machinecoding.logger.models;

import com.machinecoding.logger.utils.Utils;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class LogWriter implements LoggerVisitor<Void> {

    private String logFormat;

    public LogWriter(String logFormat) {
        this.logFormat = logFormat;
    }


    public Void visit(FileLogger fileLogger, LogMessage message) {
        return null;
    }

    public Void visit(ErrorLogger errorLogger, LogMessage message) {
        return null;
    }

    public Void visit(ConsoleLogger consoleLogger, LogMessage message) {
        System.out.println(Utils.logString(message.getMessage(), message.getLogLevel(), logFormat));
        return null;
    }
}
