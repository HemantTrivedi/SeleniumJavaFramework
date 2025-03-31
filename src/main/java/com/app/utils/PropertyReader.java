package com.app.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
  private Properties properties;

  public PropertyReader(String filePath) {
    properties = new Properties();
    try {
      FileInputStream fileInputStream = new FileInputStream(filePath);
      properties.load(fileInputStream);
    } catch (IOException e) {
      System.out.println("Error loading properties file: " + filePath + " - " + e.getMessage());
    }
  }

  public String getProperty(String key) {
    String value = properties.getProperty(key);
    if (value == null) {
      System.out.println("WARNING: Missing key in properties file: " + key);
    }
    return value;
  }
}
