package com.SendLocationToRelative.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;
@Service
public class SendSMS {
    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC042e14e7b9134febb675c948692d566f";
    public static final String AUTH_TOKEN = "2a937df10211443f1e5f4b487dbec0bc";

    public void sendSMS(String msg, String relativePhoneNumber) throws Exception {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+91"+relativePhoneNumber),
                        new com.twilio.type.PhoneNumber("+19843052392"),
                        msg)
                .create();

        System.out.println(message.getSid());
    }
}
