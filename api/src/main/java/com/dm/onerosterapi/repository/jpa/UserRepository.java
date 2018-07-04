package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByUserId(int userId);

    List<User> findAll();

}
