package com.SendLocationMasterMicroService.Repository;

import com.SendLocationMasterMicroService.Module.UserInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface GetUserInfo extends MongoRepository<UserInfo,String> {
    public UserInfo findByOwnPhoneNumber(String ownPhoneNumber);
}
