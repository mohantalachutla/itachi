package com.itachi.connect.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConnect {
    public static void main(String[] args)
    {
        Logger logger = LogManager.getLogger(TestConnect.class);
        System.out.println("Test phase initialized...");
        logger.debug("This is at debug level");
        logger.warn("This is at warn level");
        logger.error("This is at error level");
        logger.fatal("This is at fatal level");
    }
}
