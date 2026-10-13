package com.fotsfer.amazon.domain.user.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(int userId);
    User findUserByUsername(String username);
}
