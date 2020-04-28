package com.javaweb.myblog.service;

import com.javaweb.myblog.model.CommentModel;

import java.util.List;

public interface ICommentService {

    CommentModel save(CommentModel commentModel);
    List<CommentModel> findAllByPostId(Long postId);
}
