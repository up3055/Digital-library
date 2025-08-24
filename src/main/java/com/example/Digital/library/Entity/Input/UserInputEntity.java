package com.example.Digital.library.Entity.Input;

import com.example.Digital.library.Enum.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class  UserInputEntity {

    @NotBlank(message = "Name is Mendatory")
    private String name;
    private  String address;
    @NotBlank(message = "Mobile number is Mendatory")
    private String email;
    private String password;
    private String mobileNo;
    private Instant dateOfBirth;
    private UserRole role;

}
