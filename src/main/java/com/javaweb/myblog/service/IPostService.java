package com.javaweb.myblog.service;

import com.javaweb.myblog.model.PostModel;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    List<PostModel> findAll();
    Optional<PostModel> findById(Long id);
    PostModel save(PostModel postModel);
    void delete(Long id);
}
