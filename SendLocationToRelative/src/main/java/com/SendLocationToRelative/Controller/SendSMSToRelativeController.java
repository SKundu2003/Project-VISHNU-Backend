package com.SendLocationToRelative.Controller;

import com.SendLocationToRelative.POJO.UserInfo;
import com.SendLocationToRelative.Service.SendSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SendSMSToRelativeController {

    @Autowired
    SendSMS sendSMS;

    @PostMapping("/sendSMSToRelative")
    public String sendSMSToRelative(@RequestBody UserInfo victimInfo)
    {
        String msg = "Help me, I am in danger. My location is "+victimInfo.getLatitude()+" "+victimInfo.getLongitude();
        try {
            sendSMS.sendSMS(msg,victimInfo.getRelativePhoneNumber());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "Success";
    }
}
