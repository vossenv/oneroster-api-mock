package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class RosterServiceImpl implements RosterService {

    private RosterDao rosterDao;
    private UserRepository userRepository;
    private ClassRepository classRepository;
    private EnrollmentRepository enrollmentRepository;
    private CourseRepository courseRepository;
    private OrgRepository orgRepository;

    @Autowired
    public RosterServiceImpl (RosterDao rosterDao,
                              UserRepository userRepository,
                              ClassRepository classRepository,
                              EnrollmentRepository enrollmentRepository,
                              CourseRepository courseRepository,
                              OrgRepository orgRepository){

        this.rosterDao = rosterDao;
        this.userRepository = userRepository;
        this.classRepository = classRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.orgRepository = orgRepository;

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


    @Override
    public Enrollment getEnrollmentById(int enrollmentId) {
        return enrollmentRepository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<User> getUsersByClass(String classSourcedId) {
        return rosterDao.getUsersByClass(classSourcedId);
    }

    @Override
    public List<User> getAllStudents(){
        return getAllUsers().stream()
                .filter(u -> u.getRole().equals("student"))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllTeachers(){
        return getAllUsers().stream()
                .filter(u -> u.getRole().equals("teacher"))
                .collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Org getOrgById(int orgId) {
        return orgRepository.findByOrgId(orgId);
    }

    @Override
    public List<Org> getAllOrgs() {
        return orgRepository.findAll();
    }
}
