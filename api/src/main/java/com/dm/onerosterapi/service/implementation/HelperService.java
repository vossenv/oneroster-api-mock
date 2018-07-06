package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.jpa.*;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelperService {


    private SchoolRepository schoolRepository;
    private ClassRepository classRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public HelperService (
            SchoolRepository schoolRepository,
            ClassRepository classRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository
    ){
        this.schoolRepository = schoolRepository;
        this.classRepository = classRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }



    public List<?> idFieldSwap(List<?> objectList){
        objectList.forEach(this::idFieldSwap);
        return objectList;
    }

    public Object idFieldSwap(Object o){

        switch (getClassName(o)){
            case "User":
                ((User) o).setSchoolId(schoolRepository.findBySchoolId(Integer.parseInt(((User) o).getSchoolId())).getSourcedId());
                break;
        }

        return o;
    }

    private String getClassName(Object o){

        String [] temp = o.getClass().toString().split("[.]");
        return temp[temp.length - 1];

    }



}
