package com.example.Digital.library.Mapper.input;

import com.example.Digital.library.Entity.Input.UserInputEntity;
import com.example.Digital.library.Model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserInputMapper{



public UserModel mapToModel(UserInputEntity userInputEntity){
        return UserModel.builder().name(userInputEntity.getName())
                .address(userInputEntity.getAddress())
                .dateOfBirth(userInputEntity.getDateOfBirth())
                .mobileNo(userInputEntity.getMobileNo()).build();
    }
}
