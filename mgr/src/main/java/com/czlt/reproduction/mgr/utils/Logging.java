package com.czlt.reproduction.mgr.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
    private static final Logger log = LogManager.getLogger(Logging.class);

    private static String msgWithLogIdent(String msg) {
        return SessionHolder.getSessionId() + "|" + msg;
    }

    public static void debug(String msg) {
        log.debug(msgWithLogIdent(msg));
    }

    public static void debug(String msg, Throwable e) {
        log.debug(msgWithLogIdent(msg), e);
    }

    public static void error(String msg, Throwable e) {
        log.error(msgWithLogIdent(msg), e);
    }

    public static void info(String msg) {
        log.info(msgWithLogIdent(msg));
    }

    public static void warn(String msg) {
        log.warn(msgWithLogIdent(msg));
    }
}
