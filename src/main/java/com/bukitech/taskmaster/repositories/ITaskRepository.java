package com.bukitech.taskmaster.repositories;

import com.bukitech.taskmaster.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<TaskModel, Long> {
    List<TaskModel> findByGroupId(Long groupId);
    List<TaskModel> findByUserId(Long userId);
}
