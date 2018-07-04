package com.dm.onerosterapi.Service;

import com.dm.onerosterapi.dao.UserDao;
import com.dm.onerosterapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RosterServiceImpl implements RosterService {

    private UserDao userDao;

    @Autowired
    public RosterServiceImpl (UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
