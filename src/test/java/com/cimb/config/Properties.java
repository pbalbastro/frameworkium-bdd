package com.cimb.config;

public class Properties {
    public static String baseURL() {
        String environment = System.getProperty("environment");
        if (environment != null) {
            return environment;
        } else {
            return "https://www.cimb.com.my/en/personal/home.html";
        }
    }
}