package com.example.crudspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudspring.model.User;
import com.example.crudspring.services.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final UserServices userServices;

   @Autowired
   public UserController(UserServices userServices){
    this.userServices = userServices;
   }
   
   @GetMapping
   public ResponseEntity<List<User>> getAllUsers(){
    List<User> user = userServices.getAllUsers(); 
    return ResponseEntity.ok(user);
   }

   @PostMapping
   public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            User savedUser = userServices.saveUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable String id, @RequestBody User user){
     User updatedUser = userServices.updateUserById(id,user);
     if (updatedUser !=null) {
        return ResponseEntity.ok(updatedUser);
     }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
     }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
     userServices.deleteUserById(id);
     return ResponseEntity.ok("User deleted successfully");
    }

   
    @GetMapping("/username")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String name){
       List<User> user = userServices.getUserByName(name);
       return ResponseEntity.ok(user);
    }

    
}
