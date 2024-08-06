package com.example.crudspring.services.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudspring.model.User;
import com.example.crudspring.repository.UserRepo;
import com.example.crudspring.services.UserServices;

@Service
public class UserServiceImpl implements UserServices{
    
    private final UserRepo userRepo;
     
    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
       return userRepo.save(user);
    }

    @Override
    public User updateUserById(String id, User user) {
        Optional<User> existingUserOptional = userRepo.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
          if (user.getName() != null) {
            existingUser.setName(user.getName());
          }
          if(user.getEmail() != null){
            existingUser.setEmail(user.getEmail());
          }
          if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
          }
          return userRepo.save(existingUser);
        }
       return null;
    }

    @Override
    public void deleteUserById(String id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepo.findByName(name);
    }
    
}
