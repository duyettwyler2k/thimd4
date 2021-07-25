package com.codegym.module4thi.repository;

import com.codegym.module4thi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findAllByUsername(String username);
}
