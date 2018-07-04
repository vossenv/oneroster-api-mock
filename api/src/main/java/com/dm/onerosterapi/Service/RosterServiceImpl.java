package com.dm.onerosterapi.service;

import com.dm.onerosterapi.repository.UserDao;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RosterServiceImpl implements RosterService {

    private UserDao userDao;
    private UserRepository userRepository;

    @Autowired
    public RosterServiceImpl (UserDao userDao, UserRepository userRepository){
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        Set<User> s = new HashSet<>(userDao.getAllUsers());

        return new ArrayList<>(s);
    }

    @Override
    @Transactional
    public User repGetUserById(int userId) { return userRepository.findByUserId(userId); }


}
