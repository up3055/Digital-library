package com.example.Digital.library.Entity.Input;

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
    private String mobileNo;
    private Instant dateOfBirth;

}
