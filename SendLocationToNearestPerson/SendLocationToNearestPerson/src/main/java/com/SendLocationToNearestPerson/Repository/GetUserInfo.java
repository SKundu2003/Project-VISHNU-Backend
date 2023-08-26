package com.SendLocationToNearestPerson.Repository;

import com.SendLocationToNearestPerson.Module.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetUserInfo extends MongoRepository<UserInfo,String> {
    public List<UserInfo> findByLatitudeToFindUser(String latitudeToFindUser);
//    public List<UserInfo> findByLongitudeToFindUser(String longitudeToFindUser);
}
