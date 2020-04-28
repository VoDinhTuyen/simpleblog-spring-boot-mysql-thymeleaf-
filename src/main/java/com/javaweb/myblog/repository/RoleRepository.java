package com.javaweb.myblog.repository;

import com.javaweb.myblog.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    RoleModel findByRole(String role);
}
