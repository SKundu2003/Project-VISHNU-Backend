package com.SendLocationMasterMicroService.Controllers;

import com.SendLocationMasterMicroService.Repository.GetUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendLocationController {
    @Autowired
    GetUserInfo getUserInfo;
    @GetMapping("/sendLocation/{ownPhoneNumber}")
    public String sendLocation(@PathVariable(value = "ownPhoneNumber") String ownPhoneNumber)
    {
        if(getUserInfo.findByOwnPhoneNumber(ownPhoneNumber)==null)
        {
            System.err.println("user not found");
            return "No user found";
        }
        return getUserInfo.findByOwnPhoneNumber(ownPhoneNumber).getUserName();
        //call the microservice to send data to the relative
        //to police-station and all other users
    }
}
