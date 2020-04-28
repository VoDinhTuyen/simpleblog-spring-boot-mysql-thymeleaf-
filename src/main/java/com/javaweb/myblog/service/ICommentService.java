package com.javaweb.myblog.service;

import com.javaweb.myblog.model.CommentModel;

public interface ICommentService {

    CommentModel save(CommentModel commentModel);
}
