package com.javaweb.myblog.repository;

import com.javaweb.myblog.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}
