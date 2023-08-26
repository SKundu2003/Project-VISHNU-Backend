package com.SendLocationToRelative.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

@Service
public class SendSMS {
    @Value("${api.key}")
    private String apiKey;
    public void sendSMS(String msg, String number) throws IOException {
        String message = msg;
        String route = "q";
        String numberToSend = number;
        System.out.println("relative number "+ numberToSend);
        System.out.println("message is "+message);
//        String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization="+authorization+"&message="+message+"&language=english&route=q&numbers="+numberToSend+"\"";
        String myUrl = "https://google.com";
        System.out.println(myUrl);

        URL url = new URL(myUrl);
        HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("cache-control", "no-cache");
        System.out.println("Wait..............");
        int code = con.getResponseCode();
        System.out.println("Response code : " + code);
//        System.out.println("Response message : " + con.getResponseMessage());
//        System.out.println("Response body : " + con.getContent());
//        System.out.println("Response body : " + con.getContentLength());


    }
}
