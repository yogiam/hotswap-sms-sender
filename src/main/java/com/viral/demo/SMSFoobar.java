package com.viral.demo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SMSFoobar {
    private String from;
    private String to;
    private String message;

    public SMSFoobar(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public void sendSMS() {
        System.out.println("SMS sent successfully with SMSFoobar!");
    }
}
