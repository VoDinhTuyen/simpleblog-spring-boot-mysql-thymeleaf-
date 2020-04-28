package com.javaweb.myblog.repository;

import com.javaweb.myblog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {

    PostModel findOneById(Long id);
}
