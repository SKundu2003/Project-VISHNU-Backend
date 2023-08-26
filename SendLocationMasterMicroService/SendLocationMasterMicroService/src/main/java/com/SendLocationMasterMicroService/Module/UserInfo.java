package com.SendLocationMasterMicroService.Module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserInfo {
    private String ownPhoneNumber;
    private String userName;
    private String address;
    private String relativePhoneNumber;
    private String latitude;
    private String longitude;
    private String latitudeToFindUser;
    private String longitudeToFindUser;

}
