package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public abstract class AbstractLogger {

    private LoggerType loggerType;
    private AbstractLogger nextLogger;
    private LogLevel logLevel;
    private LogWriter logWriter;


    public AbstractLogger(LoggerType type, LogLevel logLevel, String logFormat) {
        this.loggerType = type;
        this.logLevel = logLevel;
        this.logWriter = new LogWriter(logFormat);

    }

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public abstract <T> T accept(LoggerVisitor<T> visitor, LogMessage logMessage);


    public void logMessage(LogMessage logMessage) {

        if (logMessage.getLogLevel().getLevel() >= this.logLevel.getLevel()) {
            accept(logWriter, logMessage);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(logMessage);
        }
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }


    public void info(String message) {
        logMessage(new LogMessage(message, LogLevel.INFO));
    }


    public void error(String message) {
        logMessage(new LogMessage(message, LogLevel.ERROR));
    }

    public void debug(String message) {
        logMessage(new LogMessage(message, LogLevel.DEBUG));
    }

}
