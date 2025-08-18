package com.example.Digital.library.Controller;

import com.example.Digital.library.Adapter.UserAdapter;
import com.example.Digital.library.Entity.Input.UserInputEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserAdapter userAdapter;

    @Autowired
    public UserController (UserAdapter  userAdapter){
        this.userAdapter = userAdapter;
    }

   @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserInputEntity userInputEntity){
        return new ResponseEntity<>(this.userAdapter.addUser(userInputEntity), HttpStatus.CREATED);
   }

   @GetMapping("/id/{id}")

    public  ResponseEntity<?> findById(@PathVariable long id ){
        return new ResponseEntity<>(this.userAdapter.findById(id) , HttpStatus.OK);
   }

   @DeleteMapping("/deleteName/{name}")
    public  ResponseEntity<?> deleteUser(@PathVariable String name){

        try{
            this.userAdapter.delete(name);
            return ResponseEntity.ok(name + "deleted Successfully");
        }
        catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
   }

   @GetMapping("/name/{name}")
    public ResponseEntity<?> findDetails(@PathVariable String name){
        return new ResponseEntity<>(this.userAdapter.findAllDetails(name) , HttpStatus.OK);
   }


}
