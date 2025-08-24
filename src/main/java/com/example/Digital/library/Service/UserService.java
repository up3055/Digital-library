package com.example.Digital.library.Service;

import com.example.Digital.library.Mapper.output.UserOutputMapper;
import com.example.Digital.library.Model.PrincipleUser;
import com.example.Digital.library.Model.UserModel;
import com.example.Digital.library.Repository.UserRepository;
import com.example.Digital.library.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

   @Autowired
    public UserService (UserRepository userRepository , UserOutputMapper userOutputMapper){

        this.userRepository = userRepository;

    }

    public UserModel addUser(UserModel userModel){

        return this.userRepository.addUser(userModel);
    }

    public UserModel findByID(long id){

        return this.userRepository.findByID(id);
    }

    public void deleteUser(String name){
        this.userRepository.DeleteUser(name);
    }

    public UserModel findDetails(String user){
       return this.userRepository.findDetails(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            UserModel userModel = this.userRepository.getUserByEmail(username);
            return new PrincipleUser(userModel);
        } catch(ResourceNotFoundException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
