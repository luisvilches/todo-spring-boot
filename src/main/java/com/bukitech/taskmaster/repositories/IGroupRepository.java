package com.bukitech.taskmaster.repositories;

import com.bukitech.taskmaster.models.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepository extends JpaRepository<GroupModel, Long> {
    List<GroupModel> findByUserId(Long userId);
}
