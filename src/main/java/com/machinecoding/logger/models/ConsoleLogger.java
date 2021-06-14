package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class ConsoleLogger extends AbstractLogger {


    public ConsoleLogger(LogLevel logLevel, String logPrefix) {
        super(LoggerType.CONSOLE, logLevel, logPrefix);
    }

    @Override
    public <T> T accept(LoggerVisitor<T> visitor, LogMessage message) {
        return visitor.visit(this, message);
    }
}
