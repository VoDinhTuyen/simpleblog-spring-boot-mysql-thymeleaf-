package com.javaweb.myblog.repository;

import com.javaweb.myblog.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserName(String userName);
    UserModel findByEmail(String email);
}
