package com.SendLocationMasterMicroService.Controllers;

import com.SendLocationMasterMicroService.Clients.SendLocationToNearPeopleFeignClient;
import com.SendLocationMasterMicroService.Clients.SendLocationToRelativeFeignClient;
import com.SendLocationMasterMicroService.Module.UserInfo;
import com.SendLocationMasterMicroService.Repository.GetUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SendLocationController {
    @Autowired
    GetUserInfo getUserInfo;


    @Autowired
    SendLocationToRelativeFeignClient sendLocationToRelativeFeignClient;

    @Autowired
    SendLocationToNearPeopleFeignClient sendLocationToNearestPeopleFeignClient;

    @GetMapping("/sendLocation/{ownPhoneNumber}")
    public String sendLocation(@PathVariable(value = "ownPhoneNumber") String ownPhoneNumber)
    {
        if(getUserInfo.findByOwnPhoneNumber(ownPhoneNumber)==null)
        {
            System.err.println("user not found");
            return "No user found";
        }
        List<UserInfo> nearestUsers =  sendLocationToNearestPeopleFeignClient.sendLocationToPeoples(getUserInfo.findByOwnPhoneNumber(ownPhoneNumber));
        String ans = sendLocationToRelativeFeignClient.sendSMSToRelative(getUserInfo.findByOwnPhoneNumber(ownPhoneNumber));
        if (ans.equals("Success"))
        {
            for (UserInfo i:nearestUsers) {
                System.out.println(i.getUserName());
            }
            System.out.println("Message sent to relative");
        }
        else
        {
            System.err.println("Message not sent to relative");
        }
        return getUserInfo.findByOwnPhoneNumber(ownPhoneNumber).getUserName();
        //call the microservice to send data to the relative
        //to police-station and all other users
    }
}
