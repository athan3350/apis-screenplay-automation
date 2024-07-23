package com.screenplay.utilities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerSetup {

    private Logger setClassLogger(String className) {
        return Logger.getLogger(className);
    }

    public void writerLogger(Level loggerType, String className, String message) {
        setClassLogger(className).log(loggerType, message);
    }
}
