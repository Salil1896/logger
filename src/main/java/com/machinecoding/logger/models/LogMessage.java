package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class LogMessage {

    private String message;
    private LogLevel logLevel;

    public LogMessage(String message, LogLevel logLevel) {
        this.message = message;
        this.logLevel = logLevel;
    }


    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
