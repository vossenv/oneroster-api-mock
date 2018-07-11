package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions1.ApiMessages;
import com.dm.onerosterapi.exceptions1.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions1.UserNotFoundException;
import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.UserRepository;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    ) {
        this.h = h;
        this.rosterDao = rosterDao;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getStudentsByClass(String classSourcedId) throws UserNotFoundException {
        return userTypeFilter(getUsersByClass(classSourcedId), "student");
    }

    @Override
    public List<User> getTeachersByClass(String classSourcedId) throws UserNotFoundException {
        return userTypeFilter(getUsersByClass(classSourcedId), "teacher");
    }

    @Override
    public List<User> getAllStudents() throws UserNotFoundException {
        return userTypeFilter(getAllUsers(), "student");
    }

    @Override
    public List<User> getAllTeachers() throws UserNotFoundException {
        return userTypeFilter(getAllUsers(), "teacher");
    }

    @Override
    public List<User> getStudentsBySchool(String schoolId) throws UserNotFoundException {
        return userTypeFilter(getUsersBySchool(schoolId), "student");
    }

    @Override
    public List<User> getTeachersBySchool(String schoolId) throws UserNotFoundException {
        return userTypeFilter(getUsersBySchool(schoolId), "teacher");
    }

    @Override
    public List<User> getStudentsForClassInSchool(String classId, String schoolId) throws UserNotFoundException {
        return userTypeFilter(getUsersForClassInSchool(classId, schoolId), "student");
    }

    @Override
    public List<User> getTeachersForClassInSchool(String classId, String schoolId) throws UserNotFoundException {
        return userTypeFilter(getUsersForClassInSchool(classId, schoolId), "teacher");
    }

    @Override
    public User getUserBySourcedId(String userId) throws UserNotFoundException {
        try {
            return (User) h.processResults(userRepository.findBySourcedId(userId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public User getStudentBySourcedId(String userId) throws UserNotFoundException {

        User u = getUserBySourcedId(userId);
        if (u.getRole().equals("student")) return u; else
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
    }

    @Override
    public User getTeacherBySourcedId(String userId) throws UserNotFoundException {

        User u = getUserBySourcedId(userId);
        if (u.getRole().equals("teacher")) return u; else
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
    }

    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        try {
            return (List<User>) h.processResults(userRepository.findAll());
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<User> getUsersByClass(String classSourcedId) throws UserNotFoundException {
        try {
            return (List<User>) h.processResults(rosterDao.getUsersByClass(classSourcedId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<User> getUsersBySchool(String schoolId) throws UserNotFoundException {
        try {
            return (List<User>) h.processResults(rosterDao.getUsersBySchool(schoolId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    @Override
    public List<User> getUsersForClassInSchool(String classId, String schoolId) throws UserNotFoundException {
        try {
            return (List<User>) h.processResults(rosterDao.getUsersForClassInSchool(classId, schoolId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new UserNotFoundException(ApiMessages.NO_RESULTS_MESSAGE);
        }
    }

    private static List<User> userTypeFilter(List<User> userList, String role) {
        return userList.stream()
                .filter(u -> u.getRole().equals(role))
                .collect(Collectors.toList());
    }

}

