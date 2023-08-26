package com.SendLocationMasterMicroService.Clients;

import com.SendLocationMasterMicroService.Module.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("relative")
public interface SendLocationToRelativeFeignClient {
    @RequestMapping(method = RequestMethod.POST ,value = "/sendSMSToRelative",consumes = "application/json")
    public String sendSMSToRelative(@RequestBody UserInfo victimInfo);
}
