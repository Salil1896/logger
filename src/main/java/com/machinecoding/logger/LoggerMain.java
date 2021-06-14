package com.machinecoding.logger;

import com.machinecoding.logger.models.AbstractLogger;
import com.machinecoding.logger.models.ConsoleLogger;
import com.machinecoding.logger.models.ErrorLogger;
import com.machinecoding.logger.models.FileLogger;
import com.machinecoding.logger.models.LogLevel;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class LoggerMain {


    public static AbstractLogger chainOfLoggers() {
        String logFormat = "[level] [date] [thread]: [message]";

        AbstractLogger consoleLogger = new ConsoleLogger(LogLevel.INFO, logFormat);
        AbstractLogger fileLogger = new FileLogger(LogLevel.INFO, logFormat);
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR, logFormat);

        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);

        return consoleLogger;
    }

    public static void main(String args[]) {
        AbstractLogger log = chainOfLoggers();

        log.info("Hey, Info World");
        log.debug("Hey, Debug World");
        log.error("Hey, Error World");

    }
}
