package com.SaveInfo.Controller;

import com.SaveInfo.Modules.UserInfo;
import com.SaveInfo.POJO.UserDetailsClass;
import com.SaveInfo.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaveUserInfoController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping("/saveUserInfo")
    public String saveUserInfo(@RequestBody UserDetailsClass u)
    {
        System.out.println(u);
        UserInfo user = new UserInfo(u.getOwnPhoneNumber(),u.getUserName(),u.getAddress(),u.getRelativePhoneNumber(),u.getNonStaticLatitude(),u.getNonStaticLongitude());
        double latitudeToFindUser = Double.parseDouble(String.valueOf(u.getNonStaticLatitude()));
        latitudeToFindUser = latitudeToFindUser * 10000;
        double longitudeToFindUser = Double.parseDouble(String.valueOf(u.getNonStaticLongitude()));
        longitudeToFindUser = longitudeToFindUser * 10000;
        int latitudeToFindUserInt = (int) latitudeToFindUser;
        int longitudeToFindUserInt = (int)longitudeToFindUser;
        System.out.println(latitudeToFindUserInt);
        System.out.println(longitudeToFindUserInt);
        user.setLatitudeToFindUser(Integer.toString(latitudeToFindUserInt));
        user.setLongitudeToFindUser(Integer.toString(longitudeToFindUserInt));
        userInfoRepository.deleteUserInfoByOwnPhoneNumber(u.getOwnPhoneNumber());
        userInfoRepository.save(user);
        System.out.println("saved");
        return "success";
//        System.err.println(u);
//        ConvertStringIntoClassObj.convertStringIntoClassObj(u);
//        System.out.println(u.getUserName());
//        System.out.println(u.getOwnPhoneNumber());
//        System.out.println(u.getAddress());
//        System.out.println(u.getRelativePhoneNumber());
//        System.out.println(u.getLatitude());
//        System.out.println(u.getLongitude());
    }
    @GetMapping("/getUser/{number}")
    public String getUser(@PathVariable(value = "number") String number)
    {
        if(userInfoRepository.findByOwnPhoneNumber(number)==null)
        {
            return "No user found";
        }
        else
        {
            return userInfoRepository.findByOwnPhoneNumber(number).getUserName();
        }
    }

    @PostMapping("/test")
    public String test(@RequestBody String str)
    {
        System.out.println("test");
        return "success";
    }
}
