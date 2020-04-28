package com.javaweb.myblog.repository;

import com.javaweb.myblog.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {

    List<CommentModel> findAllByPostId(Long postId);
}
