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
    public void saveUserInfo(@RequestBody UserDetailsClass u)
    {
        UserInfo user = new UserInfo(u.getOwnPhoneNumber(),u.getUserName(),u.getAddress(),u.getRelativePhoneNumber(),u.getLatitude(),u.getLongitude());
        double latitudeToFindUser = Double.parseDouble(u.getLatitude()) * 10000;
        double longitudeToFindUser = Double.parseDouble(u.getLongitude()) * 10000;
        int latitudeToFindUserInt = (int) latitudeToFindUser;
        int longitudeToFindUserInt = (int) longitudeToFindUser;
        user.setLatitudeToFindUser(Integer.toString(latitudeToFindUserInt));
        user.setLongitudeToFindUser(Integer.toString(longitudeToFindUserInt));
        userInfoRepository.save(user);
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
}
