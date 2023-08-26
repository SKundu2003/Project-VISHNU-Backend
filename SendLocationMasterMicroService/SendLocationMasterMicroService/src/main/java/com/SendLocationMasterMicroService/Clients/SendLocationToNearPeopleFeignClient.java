package com.SendLocationMasterMicroService.Clients;


import com.SendLocationMasterMicroService.Module.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("nearestperson")
public interface SendLocationToNearPeopleFeignClient {
    @RequestMapping(method = RequestMethod.POST,value = "/sendLocationToNearestPeople",consumes = "application/json")
    List<UserInfo> sendLocationToPeoples(@RequestBody UserInfo victimInfo);
}
