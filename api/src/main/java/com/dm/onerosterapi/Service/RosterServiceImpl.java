package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.repository.jpa.UserRepository;
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

    private RosterDao rosterDao;
    private UserRepository userRepository;
    private ClassRepository classRepository;

    @Autowired
    public RosterServiceImpl (RosterDao rosterDao,
                              UserRepository userRepository,
                              ClassRepository classRepository){

        this.rosterDao = rosterDao;
        this.userRepository = userRepository;
        this.classRepository = classRepository;
    }

    @Override
    public ClassOfCourse getClassById(int classId) {
        return classRepository.findByClassId(classId);
    }

    @Override
    public List<ClassOfCourse> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
