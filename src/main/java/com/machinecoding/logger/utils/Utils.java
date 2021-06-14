package com.machinecoding.logger.utils;

import com.machinecoding.logger.models.LogLevel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author salil.mamodiya
 * 14/06/21
 */
public class Utils {

    public static Map<String, String> logPlaceHolders(String message, LogLevel logLevel) {
        Map<String, String> placeHolderMap = new HashMap<String, String>();

        placeHolderMap.put("message", message);
        placeHolderMap.put("thread", Long.toString(Thread.currentThread().getId()));
        placeHolderMap.put("level", logLevel.toString());
        placeHolderMap.put("date", new Date().toString());
        return placeHolderMap;
    }


    public static String logString(String message, LogLevel logLevel, String logFormat) {
        Map<String, String> placeHolderMap = logPlaceHolders(message, logLevel);

        for (Map.Entry<String, String> e : placeHolderMap.entrySet()) {
            logFormat = logFormat.replaceAll("\\[" + e.getKey() + "\\]", e.getValue());
        }
        return logFormat;
    }
}
