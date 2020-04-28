package com.javaweb.myblog.service.impl;

import com.javaweb.myblog.model.PostModel;
import com.javaweb.myblog.repository.PostRepository;
import com.javaweb.myblog.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostModel> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostModel> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostModel save(PostModel postModel) {
        return postRepository.save(postModel);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
