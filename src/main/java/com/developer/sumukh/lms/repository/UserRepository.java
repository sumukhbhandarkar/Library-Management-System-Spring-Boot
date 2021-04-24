package com.developer.sumukh.lms.repository;

import com.developer.sumukh.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
