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
    public User getUserById(int userId) {
        return rosterDao.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>(new HashSet<>(rosterDao.getAllUsers()));

        for (User u : userList){
            for (Enrollment e : u.getEnrollmentList()){
                ClassOfCourse c = getClassById(Integer.parseInt(e.getClassId()));
                u.getClassList().add(c);
                //u.getClassList().add(getClassById(1));
            }
        }

        return userList;
    }

    @Override
    public ClassOfCourse getClassById(int classId) {
        return classRepository.findByClassId(classId);
    }

    @Override
    public List<ClassOfCourse> getAllClasses() {
        return null;
    }
}
