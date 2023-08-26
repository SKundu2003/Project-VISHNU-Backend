package com.SaveInfo.Modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String ownPhoneNumber;
    private String userName;
    private String address;
    private String relativePhoneNumber;
    private String latitude;
    private String longitude;
    private String latitudeToFindUser;
    private String longitudeToFindUser;

    public UserInfo(String ownPhoneNumber, String userName, String address, String relativePhoneNumber, String latitude, String longitude) {
        this.ownPhoneNumber = ownPhoneNumber;
        this.userName = userName;
        this.address = address;
        this.relativePhoneNumber = relativePhoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
