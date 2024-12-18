package com.ecommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//This ReadConfig file is used to read values from config.properties file
public class Readconfig {
    // Create object of properties class
    Properties properties; // create object of properties class to read properties file

    //Path of properties file
    String path = "C:\\Users\\Home\\IdeaProjects\\EcommerceTesting\\Configuration\\Config.properties";

    //Create constructor
    public Readconfig(){
        // Initialize properties variable
        properties = new Properties();

        // Read properties file
        try {
            // Create object of FileInputStream class to read properties file
            FileInputStream fileInputStream = new FileInputStream(path);
            // Load the properties file
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // Create methods to read values from properties file
    public String getBaseUrl() {
        // read values
        String value = properties.getProperty("baseUrl");
        //String value = properties.getProperty("url");
        // Check whether the value returned is null or not
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("URL not specified in config file");
        }
    }

    public String getBrowser() {
        // read values
        String value = properties.getProperty("browser");
        // Check whether the value returned is null or not
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("browser not specified in config file");
        }
    }

    public String getUserName() {
        // read values
        String value = properties.getProperty("username");
        //String value = properties.getProperty("uName");
        // Check whether the value returned is null or not
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("username not specified in config file");
        }
    }
    public String getPassword() {
        // read values
        String value = properties.getProperty("password");
        //String value = properties.getProperty("pwd");
        // Check whether the value returned is null or not
        if (value != null) {
            return value;
        } else {
            throw new RuntimeException("password not specified in config file");
        }
    }
}


