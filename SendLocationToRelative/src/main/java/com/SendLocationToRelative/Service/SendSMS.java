package com.SendLocationToRelative.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

@Service
public class SendSMS {
    public String sendSMS(String msg, String number) {
            try {
                // Construct data
                String apiKey = "apikey=" + "NzIzNDM2NDIzNTY4NzU2YjQ0Njg1MjMyNmI0YjZhNmE=";
                String message = "&message=" + msg;
                String sender = "&sender=" + "TXTLCL";
                String numbers = "&numbers=" + number;

                // Send data
                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                String data = apiKey + numbers + message + sender;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();
                System.out.println("Message sent");
                return stringBuffer.toString();
            } catch (Exception e) {
                System.out.println("Error SMS "+e);
                return "Error "+e;
            }
    }
}
