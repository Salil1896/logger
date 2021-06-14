package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class ErrorLogger extends AbstractLogger {


    public ErrorLogger(LogLevel logLevel, String logPrefix) {
        super(LoggerType.ERROR, logLevel, logPrefix);
    }


    @Override
    public <T> T accept(LoggerVisitor<T> visitor, LogMessage message) {
        return visitor.visit(this, message);
    }
}
