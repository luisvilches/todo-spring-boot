package com.bukitech.taskmaster.controllers;


import com.bukitech.taskmaster.classes.RemoveResponse;
import com.bukitech.taskmaster.models.GroupModel;
import com.bukitech.taskmaster.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping
    public ArrayList<GroupModel> getGroups(){
        return this.groupService.getGroups();
    }

    @GetMapping("/{id}")
    public Optional<GroupModel> getById(@PathVariable("id") Long id){
        return this.groupService.getById(id);
    }

    @GetMapping("/user/{id}")
    public ArrayList<GroupModel> getByUserId(@PathVariable("id") Long id){
        return (ArrayList<GroupModel>) this.groupService.getByUserId(id);
    }

    @PostMapping
    public GroupModel create(@RequestBody GroupModel group){
        return this.groupService.create(group);
    }

    @PutMapping("/{id}")
    public GroupModel update(@PathVariable("id") Long id, @RequestBody GroupModel group){
        return this.groupService.update(id, group);
    }

    @DeleteMapping("/{id}")
    public RemoveResponse delete(@PathVariable("id") Long id){
        boolean success = this.groupService.remove(id);
        String message = success ? "success delete" : "fail delete";
        return new RemoveResponse(success, message);
    }
}
