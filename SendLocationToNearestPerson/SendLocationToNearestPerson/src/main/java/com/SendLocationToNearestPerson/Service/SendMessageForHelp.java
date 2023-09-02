package com.SendLocationToNearestPerson.Service;

import com.SendLocationToNearestPerson.Module.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

//Class to send message to the nearest person
@Service
public class SendMessageForHelp {
    //
    @Value("${api.key}")
    private String apiKey;
    public static void sendSMS(String msg, String number) throws IOException {
        String message = msg;
        String route = "q";
        String numberToSend = number;
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
    public void sendMessageForHelp(List<UserInfo> userInfos, UserInfo victimInfo) throws UnsupportedEncodingException {
        String msg = "I am "+victimInfo.getUserName() +" Help me I am in danger. My location is "+victimInfo.getLatitude()+" "+victimInfo.getLongitude();
        msg = URLEncoder.encode(msg, "UTF-8");

        try {
            sendSMS(msg,userInfos.get(0).getOwnPhoneNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
