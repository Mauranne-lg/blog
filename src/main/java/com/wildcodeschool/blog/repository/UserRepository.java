package com.wildcodeschool.blog.repository;

import com.wildcodeschool.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPseudo(String pseudo);
    boolean existsByEmail(String email);
}

