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
    private String nonStaticLatitude;
    private String nonStaticLongitude;

}
