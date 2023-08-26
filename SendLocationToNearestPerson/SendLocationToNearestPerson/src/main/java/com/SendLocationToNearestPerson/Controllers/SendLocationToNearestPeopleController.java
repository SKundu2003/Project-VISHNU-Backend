package com.SendLocationToNearestPerson.Controllers;

import com.SendLocationToNearestPerson.Module.UserInfo;
import com.SendLocationToNearestPerson.Repository.GetUserInfo;
import com.SendLocationToNearestPerson.Service.FilterOutUsers;
import com.SendLocationToNearestPerson.Service.SendMessageForHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
public class SendLocationToNearestPeopleController {

    @Autowired
    GetUserInfo userInfo;

    @Autowired
    FilterOutUsers filterOutUsers;

    @Autowired
    SendMessageForHelp sendMessageForHelp;

    @GetMapping("/sendLocationToNearestPeople")
    public List<UserInfo> sendLocationToNearestPeople(@RequestBody UserInfo victimInfo)
    {
        List<UserInfo> userInfosByLatitude = userInfo.findByLatitudeToFindUser(victimInfo.getLatitudeToFindUser());
        //call the filterOutUsers method to filter out the users
        if(userInfosByLatitude.isEmpty())
        {
            System.err.println("No user found");
            return null;
        }
        sendMessageForHelp.sendMessageForHelp(userInfosByLatitude,victimInfo);
        return filterOutUsers.filterOutUsers(victimInfo,userInfosByLatitude);
//        return "Success";
    }
}
