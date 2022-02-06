package org.selenium.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){

        try {
            properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
        } catch (Throwable e ){
            throw new IllegalStateException("Invalid property file " + e);
        }
    }

    public static ConfigLoader getInstance(){
        if (configLoader ==null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBrowser(){
        String prop = properties.getProperty("browser");
        if (prop != null) return prop;
        else throw new RuntimeException("Property browser is not specified in the config.properties file");
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the config.properties file");
    }
}
