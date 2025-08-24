package com.example.Digital.library.Model;


import com.example.Digital.library.Enum.UserRole;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.With;

import java.time.Instant;

@Builder
@Data
@With
public class UserModel {

    private long id;
    private String name;
    private String address;
    private  String mobileNo;
    private  String email;
    private String password;
    private UserRole role;
    private Instant dateOfBirth;

}
