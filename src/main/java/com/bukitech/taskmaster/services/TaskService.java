package com.bukitech.taskmaster.services;

import com.bukitech.taskmaster.models.GroupModel;
import com.bukitech.taskmaster.models.TaskModel;
import com.bukitech.taskmaster.repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    ITaskRepository taskRepository;

    public ArrayList<TaskModel> getTasks(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }

    public Optional<TaskModel> getById(Long id){
        return taskRepository.findById(id);
    }

    public ArrayList<TaskModel> getByGroupId(Long id){
        return (ArrayList<TaskModel>) taskRepository.findByGroupId(id);
    }

    public ArrayList<TaskModel> getByUserId(Long id){
        return (ArrayList<TaskModel>) taskRepository.findByUserId(id);
    }

    public TaskModel create(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel update(Long id, TaskModel task){
        TaskModel data = taskRepository.findById(id).get();
        data.setName(task.getName());
        data.setDescription(task.getDescription());
        data.setCompleted(task.isCompleted());
        return data;
    }

    public TaskModel changeStatusCompleted(Long id, boolean status){
        TaskModel data = taskRepository.findById(id).get();
        data.setCompleted(status);
        return data;
    }

    public boolean remove(Long id){
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
