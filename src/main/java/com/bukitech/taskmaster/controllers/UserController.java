package com.bukitech.taskmaster.controllers;

import com.bukitech.taskmaster.classes.RemoveResponse;
import com.bukitech.taskmaster.models.UserModel;
import com.bukitech.taskmaster.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id){
        return this.userService.findById(id);
    }

    @PostMapping
    public UserModel create(@RequestBody UserModel user){
        return this.userService.create(user);
    }

    @PutMapping("/{id}")
    public UserModel update(@PathVariable("id") Long id, @RequestBody UserModel user){
        return this.userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public RemoveResponse delete(@PathVariable("id") Long id){
        boolean success = this.userService.remove(id);
        String message = success ? "delete success":" error delete user";
        return new RemoveResponse(success, message);
    }
}
