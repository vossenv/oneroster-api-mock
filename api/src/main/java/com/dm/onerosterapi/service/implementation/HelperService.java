package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.repository.jpa.*;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class HelperService {


    private SchoolRepository schoolRepository;
    private ClassRepository classRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public HelperService(
            SchoolRepository schoolRepository,
            ClassRepository classRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository
    ) {
        this.schoolRepository = schoolRepository;
        this.classRepository = classRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }


    public List<?> idFieldSwap(List<?> objectList) throws IllegalAccessException {
        for (Object o : objectList) { idFieldSwap(o); }
        return objectList;
    }

    public Object idFieldSwap(Object o) throws IllegalAccessException {

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (!field.getType().toString().equals("int")) {

                int fieldVal = Integer.parseInt(field.get(o).toString());
                switch (field.getName()) {
                    case "schoolId": field.set(o, schoolRepository.findBySchoolId(fieldVal).getSourcedId()); break;
                    case "userId": field.set(o, userRepository.findByUserId(fieldVal).getSourcedId()); break;
                    case "courseId": field.set(o, courseRepository.findByCourseId(fieldVal).getSourcedId()); break;
                    case "classId": field.set(o, classRepository.findByClassId(fieldVal).getSourcedId()); break;
                }
            }
        }

        return o;
    }


}
