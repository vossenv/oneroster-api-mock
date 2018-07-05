package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.*;
import com.dm.onerosterapi.service.interfaces.RosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

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

        List<User> userList = new ArrayList<>();

        for (User u : userRepository.findAll()){
            u.setOrgId(getOrgById(Integer.parseInt(u.getOrgId())).getSourcedId());
            userList.add(u);
        }

        return userList;
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

    private static List<User> userTypeFilter(List<User> userList, String role){
        return userList.stream()
                .filter(u -> u.getRole().equals(role))
                .collect(Collectors.toList());
    }

}
