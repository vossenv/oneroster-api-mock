package com.dm.onerosterapi.Service;

import com.dm.onerosterapi.Repository.UserRepository;
import com.dm.onerosterapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserId(String userId) {
        return null;
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }
}
