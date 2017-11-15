package com.forex.analysis.util;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;


public class AppProperties {

    private static final String FILENAME = "application.properties";

    private static final Properties properties = new Properties();

    static {
        URL props = ClassLoader.getSystemResource(FILENAME);

        if (props == null) {
            throw new PropertyException("Property file '" + FILENAME + "' not found in the classpath.");
        }

        try {
            properties.load(props.openStream());
        } catch (IOException e) {
            throw new PropertyException("Could not load properties.");
        }
    }

    public static String getFilePathInput() {
        return properties.getProperty("FILE_PATH_INPUT");
    }

    public static String getFilePathOutput() {
        return properties.getProperty("FILE_PATH_OUTPUT");
    }
}
