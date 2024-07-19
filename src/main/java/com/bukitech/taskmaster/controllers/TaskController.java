package com.bukitech.taskmaster.controllers;

import com.bukitech.taskmaster.classes.CompletedRequest;
import com.bukitech.taskmaster.classes.RemoveResponse;
import com.bukitech.taskmaster.models.TaskModel;
import com.bukitech.taskmaster.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ArrayList<TaskModel> getTasks(){
        return (ArrayList<TaskModel>) this.taskService.getTasks();
    }

    @GetMapping("/group/{id}")
    public ArrayList<TaskModel> getByGroup(@PathVariable("id") Long groupId){
        return (ArrayList<TaskModel>) this.taskService.getByGroupId(groupId);
    }

    @GetMapping("/user/{id}")
    public ArrayList<TaskModel> getByUserId(@PathVariable("id") Long id){
        return (ArrayList<TaskModel>) this.taskService.getByUserId(id);
    }

    @GetMapping("/{id}")
    public Optional<TaskModel> getById(@PathVariable("id") Long id){
        return this.taskService.getById(id);
    }

    @PostMapping
    public TaskModel create(@RequestBody TaskModel task){
        return this.taskService.create(task);
    }

    @PutMapping("/{id}")
    public TaskModel update(@PathVariable("id") Long id, @RequestBody TaskModel task){
        return this.taskService.update(id, task);
    }

    @PutMapping("/status/{id}")
    public TaskModel changeStatusCompleted(@PathVariable("id") Long id, @RequestBody CompletedRequest completed){
        return this.taskService.changeStatusCompleted(id, completed.isCompleted());
    }

    @DeleteMapping("/{id}")
    public RemoveResponse remove(@PathVariable("id") Long id){
        boolean success = this.taskService.remove(id);
        String message = success ? "succes delete" : "fail delete";
        return new RemoveResponse(success, message);
    }
}
