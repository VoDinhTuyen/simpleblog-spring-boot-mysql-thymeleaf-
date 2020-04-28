package com.javaweb.myblog.service.impl;

import com.javaweb.myblog.model.RoleModel;
import com.javaweb.myblog.model.UserModel;
import com.javaweb.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUserName(username);
        if(userModel == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleModel role: userModel.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        UserDetails userDetails = new User(userModel.getUserName(), userModel.getPassword(), true, true, true, true, authorities);
        return userDetails;
    }
}
