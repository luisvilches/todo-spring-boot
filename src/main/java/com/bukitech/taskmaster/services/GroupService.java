package com.bukitech.taskmaster.services;

import com.bukitech.taskmaster.models.GroupModel;
import com.bukitech.taskmaster.models.TaskModel;
import com.bukitech.taskmaster.repositories.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    IGroupRepository groupRepository;

    public GroupModel create(GroupModel group){
        return groupRepository.save(group);
    }

    public ArrayList<GroupModel> getGroups(){
        return (ArrayList<GroupModel>) groupRepository.findAll();
    }

    public ArrayList<GroupModel> getByUserId(Long id){
        return (ArrayList<GroupModel>) groupRepository.findByUserId(id);
    }

    public Optional<GroupModel> getById(Long id){
        return groupRepository.findById(id);
    }

    public GroupModel update(Long id, GroupModel group){
        GroupModel data = groupRepository.findById(id).get();
        data.setName(group.getName());
        data.setDescription(group.getDescription());
        return data;
    }

    public boolean remove(Long id){
        try {
            groupRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
