package com.dm.onerosterapi.dao;

import com.dm.onerosterapi.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(int userId);

}
