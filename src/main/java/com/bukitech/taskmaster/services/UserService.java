package com.bukitech.taskmaster.services;

import com.bukitech.taskmaster.models.UserModel;
import com.bukitech.taskmaster.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public UserModel create(UserModel user){
        return userRepository.save(user);
    }

    public UserModel update(Long id, UserModel user){
        UserModel data = userRepository.findById(id).get();
        data.setName(user.getName());
        data.setLastname(user.getLastname());
        data.setEmail(user.getEmail());
        data.setPassword(user.getPassword());
        return data;
    }

    public boolean remove(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
