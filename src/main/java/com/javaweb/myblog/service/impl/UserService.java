package com.javaweb.myblog.service.impl;

import com.javaweb.myblog.model.UserModel;
import com.javaweb.myblog.repository.RoleRepository;
import com.javaweb.myblog.repository.UserRepository;
import com.javaweb.myblog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private static final String USER_ROLE = "ROLE_USER";

    @Override
    public UserModel findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserModel save(UserModel userModel) {
        userModel.setActive(1);
        userModel.setRoles(Collections.singletonList(roleRepository.findByRole(USER_ROLE)));
        userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }
}

