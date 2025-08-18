package com.example.Digital.library.Repository;

import com.example.Digital.library.Entity.Output.OutputEntity;
import com.example.Digital.library.Entity.Output.UserOutputEntity;
import com.example.Digital.library.Mapper.output.UserOutputMapper;
import com.example.Digital.library.Model.UserModel;
import com.example.Digital.library.Repository.jpa.BookJpaRepository;
import com.example.Digital.library.Repository.jpa.UserJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserOutputMapper userOutputMapper;
   @Autowired
    public UserRepository(UserJpaRepository userJpaRepository , UserOutputMapper userOutputMapper){
        this.userJpaRepository = userJpaRepository;
        this.userOutputMapper = userOutputMapper;
    }

    public UserModel addUser(UserModel userModel){

        UserOutputEntity outputEntity = this.userOutputMapper.mapFromModel(userModel);

        UserOutputEntity savedToDB = this.userJpaRepository.save(outputEntity);

        return this.userOutputMapper.mapToModel(savedToDB);

    }

    public UserModel findByID(long id){

        Optional<UserOutputEntity> optionalOutputEntity = this.userJpaRepository.findById(id);

        return optionalOutputEntity.map(this.userOutputMapper :: mapToModel).orElseThrow( () ->  new EntityNotFoundException("User not Exits with " + id));
    }
@Transactional
    public void DeleteUser(String name){

        if (!userJpaRepository.existsByName(name)) {

            throw new EntityNotFoundException("User name with " + name + "not exits");
        }
        this.userJpaRepository.deleteByName(name);

    }

    public UserModel findDetails(String user){

       if(!userJpaRepository.existsByName(user)){
           throw new EntityNotFoundException("User name with " + user + "not exits");
       }
       return userOutputMapper.mapToModel(this.userJpaRepository.findByNameIgnoreCase(user));
    }




}
