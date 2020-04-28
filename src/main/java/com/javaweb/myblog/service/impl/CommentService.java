package com.javaweb.myblog.service.impl;

import com.javaweb.myblog.model.CommentModel;
import com.javaweb.myblog.repository.CommentRepository;
import com.javaweb.myblog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentModel save(CommentModel commentModel) {
        return commentRepository.save(commentModel);
    }

    @Override
    public List<CommentModel> findAllByPostId(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }
}
