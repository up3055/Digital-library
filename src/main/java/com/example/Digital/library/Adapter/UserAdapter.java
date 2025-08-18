package com.example.Digital.library.Adapter;

import com.example.Digital.library.Entity.Input.UserInputEntity;
import com.example.Digital.library.Mapper.input.UserInputMapper;
import com.example.Digital.library.Model.UserModel;
import com.example.Digital.library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    private final UserInputMapper userInputMapper;
    private final UserService userService;

    @Autowired
    public UserAdapter (UserInputMapper userInputMapper, UserService userService){

        this.userInputMapper = userInputMapper;
        this.userService = userService;
    }

    public UserModel addUser(UserInputEntity userInputEntity){

        return this.userService.addUser(this.userInputMapper.mapToModel(userInputEntity));
    }

    public UserModel findById(long id){
        return this.userService.findByID(id);
    }


    public  void  delete(String name ){

        this.userService.deleteUser(name);
    }

    public UserModel findAllDetails(String name){
        return this.userService.findDetails(name);
    }
}
