package com.javaweb.myblog.service;

import com.javaweb.myblog.model.UserModel;

import java.util.Optional;

public interface IUserService {

    UserModel findByUserName(String userName);
    UserModel findByEmail(String email);
    UserModel save(UserModel userModel);
}
