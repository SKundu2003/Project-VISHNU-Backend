package com.SaveInfo.POJO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailsClass {
    private String ownPhoneNumber;
    private String userName;
    private String address;
    private String relativePhoneNumber;
    private String latitude;
    private String longitude;
    private String latitudeToFindUser;
    private String longitudeToFindUser;

    public UserDetailsClass(String ownPhoneNumber, String userName, String address, String relativePhoneNumber, String latitude, String longitude) {
        this.ownPhoneNumber = ownPhoneNumber;
        this.userName = userName;
        this.address = address;
        this.relativePhoneNumber = relativePhoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
