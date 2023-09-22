package com.viral.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class DynamicClassLoader {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);

            String className = prop.getProperty("classname");

            Class<?> dynamicClass = Class.forName(className);

            Object instance = dynamicClass.getConstructor(String.class, String.class, String.class)
                                          .newInstance("BILLDSK", "9867798677", "Hello, this is a test message!");

            Method sendSMSMethod = dynamicClass.getMethod("sendSMS");
            sendSMSMethod.invoke(instance);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
