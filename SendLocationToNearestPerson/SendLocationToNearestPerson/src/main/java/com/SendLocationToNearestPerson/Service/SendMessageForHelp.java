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

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

//Class to send message to the nearest person
@Service
public class SendMessageForHelp {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC042e14e7b9134febb675c948692d566f";
    public static final String AUTH_TOKEN = "2a937df10211443f1e5f4b487dbec0bc";

    public void sendSMS(String msg, String relativePhoneNumber) throws Exception {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+917439175887"),
                        new com.twilio.type.PhoneNumber("+19843052392"),
                        "Your message")
                .create();

        System.out.println(message.getSid());
    }
    public void sendMessageForHelp(List<UserInfo> userInfos, UserInfo victimInfo) throws UnsupportedEncodingException {
        String msg = "I am "+victimInfo.getUserName() +" Help me I am in danger. My location is "+victimInfo.getLatitude()+" "+victimInfo.getLongitude();
        msg = URLEncoder.encode(msg, "UTF-8");

        try {
//            sendSMS(msg,userInfos.get(0).getOwnPhoneNumber());
            System.out.println("Sending message to "+userInfos.get(0).getOwnPhoneNumber());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
