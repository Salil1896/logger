package com.machinecoding.logger.models;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public interface LoggerVisitor<T> {

    T visit(ConsoleLogger consoleLogger, LogMessage message);

    T visit(ErrorLogger errorLogger, LogMessage message);

    T visit(FileLogger fileLogger, LogMessage message);
}
