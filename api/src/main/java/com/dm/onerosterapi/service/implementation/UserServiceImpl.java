package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.UserRepository;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("unchecked")
public class UserServiceImpl implements UserService {

    private HelperService h;
    private RosterDao rosterDao;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(
            HelperService h,
            RosterDao rosterDao,
            UserRepository userRepository
    ){
        this.h = h;
        this.rosterDao = rosterDao;
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(int userId) {
        return (User) h.idFieldSwap(userRepository.findByUserId(userId));
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) h.idFieldSwap(userRepository.findAll());
    }

    @Override
    public List<User> getUsersByClass(String classSourcedId) {
        return (List<User>) h.idFieldSwap(rosterDao.getUsersByClass(classSourcedId));
    }

    @Override
    public List<User> getStudentsByClass(String classSourcedId){
        return userTypeFilter(getUsersByClass(classSourcedId),"student");
    }

    @Override
    public List<User> getTeachersByClass(String classSourcedId){
        return userTypeFilter(getUsersByClass(classSourcedId),"teacher");
    }

    @Override
    public List<User> getAllStudents(){
        return userTypeFilter(getAllUsers(),"student");
    }

    @Override
    public List<User> getAllTeachers(){
        return userTypeFilter(getAllUsers(),"teacher");
    }

    private static List<User> userTypeFilter(List<User> userList, String role){
        return userList.stream()
                .filter(u -> u.getRole().equals(role))
                .collect(Collectors.toList());
    }
}

