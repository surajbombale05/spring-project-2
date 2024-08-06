package com.example.crudspring.services;

import java.util.List;


import com.example.crudspring.model.User;

public interface  UserServices {
    public List<User> getAllUsers();
    public User saveUser(User user);
    public List<User> getUserByName(String name);
    public User updateUserById(String id,User user);
    public void deleteUserById(String id);
}
