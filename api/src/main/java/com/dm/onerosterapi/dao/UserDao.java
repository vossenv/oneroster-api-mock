package com.dm.onerosterapi.dao;

import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;



public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int userId);

}
