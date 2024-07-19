package com.bukitech.taskmaster.repositories;

import com.bukitech.taskmaster.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository  extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

}
