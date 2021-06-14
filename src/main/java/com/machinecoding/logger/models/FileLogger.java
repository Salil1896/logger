package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(LogLevel logLevel,
                      String logFormat) {
        super(LoggerType.FILE, logLevel, logFormat);
    }


    @Override
    public <T> T accept(LoggerVisitor<T> visitor, LogMessage message) {
        return visitor.visit(this, message);
    }
}
