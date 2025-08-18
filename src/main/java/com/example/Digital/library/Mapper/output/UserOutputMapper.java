package com.example.Digital.library.Mapper.output;

import com.example.Digital.library.Entity.Output.UserOutputEntity;
import com.example.Digital.library.Model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserOutputMapper {



    public UserModel mapToModel(UserOutputEntity userOutputEntity){

        return UserModel.builder().id(userOutputEntity.getId())
                .name(userOutputEntity.getName())
                .address(userOutputEntity.getAddress())
                .mobileNo(userOutputEntity.getMobileNo())
                .dateOfBirth(userOutputEntity.getDateOfBirth()).build();
    }

    public UserOutputEntity mapFromModel(UserModel userModel){

        return UserOutputEntity.builder()
                .id(userModel.getId())
                .name(userModel.getName())
                .address(userModel.getAddress())
                .mobileNo(userModel.getMobileNo())
                .dateOfBirth(userModel.getDateOfBirth()).build();
    }

}
