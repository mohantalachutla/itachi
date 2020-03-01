package com.itachi.connect.startup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHandler {
    public Logger getLoggerBean(Class cls)
    {
        return LogManager.getLogger(cls);
    }
}
