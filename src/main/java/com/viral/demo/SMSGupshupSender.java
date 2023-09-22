package com.viral.demo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class SMSGupshupSender {
    private String from;
    private String to;
    private String message;

    public SMSGupshupSender(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    public void sendSMS() {
        try {
            String apiUrl = "https://enterprise.smsgupshup.com/GatewayAPI/rest";

            String apiKey = "API_KEY";

            String urlParameters = "method=sendMessage&send_to=" + to + "&msg=" + message + "&msg_type=TEXT&auth_scheme=PLAIN&mask=" + from + "&userid=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = urlParameters.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("SMS sent successfully with SMSGupshup!");
            } else {
                System.out.println("Failed to send SMS. Response Code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
