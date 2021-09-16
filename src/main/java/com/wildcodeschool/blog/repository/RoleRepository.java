package com.wildcodeschool.blog.repository;

import com.wildcodeschool.blog.entity.ERole;
import com.wildcodeschool.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole roleUser);

}
