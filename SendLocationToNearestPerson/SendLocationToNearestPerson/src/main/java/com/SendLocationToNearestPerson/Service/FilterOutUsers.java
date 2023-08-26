package com.SendLocationToNearestPerson.Service;

import com.SendLocationToNearestPerson.Module.UserInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class FilterOutUsers {
    public List<UserInfo> filterOutUsers(UserInfo victimInfo, List<UserInfo> userInfosByLatitude)
    {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (UserInfo userInfo:userInfosByLatitude) {
            if(userInfo.getLatitudeToFindUser().equals(victimInfo.getLatitudeToFindUser()))
            {
                userInfoList.add(userInfo);
            }
        }
        return userInfoList;
    }
}
