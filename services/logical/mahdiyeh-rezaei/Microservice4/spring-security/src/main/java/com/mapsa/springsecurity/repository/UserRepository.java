package com.mapsa.springsecurity.repository;

import com.mapsa.springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String Username);
}
