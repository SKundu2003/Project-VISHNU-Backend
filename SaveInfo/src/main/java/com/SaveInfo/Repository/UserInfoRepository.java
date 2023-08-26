package com.SaveInfo.Repository;

import com.SaveInfo.Modules.UserInfo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Configuration
public interface UserInfoRepository extends MongoRepository<UserInfo,String>{
    public UserInfo findByOwnPhoneNumber(String ownPhoneNumber);
    public UserInfo findByUserName(String userName);
}
