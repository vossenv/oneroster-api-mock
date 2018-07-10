package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.repository.jpa.*;
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

        for (Field field : o.getClass().getDeclaredFields()){
            field.setAccessible(true);

            try{

                String fieldVal = field.get(o).toString();

                switch (field.getName()) {
                    case "schoolId": field.set(o,schoolRepository.findBySchoolId(fieldVal).getSourcedId()); break;
                    case "userId": field.set(o,userRepository.findByUserId(fieldVal).getSourcedId()); break;
                    case "courseId": field.set(o,courseRepository.findByCourseId(fieldVal).getSourcedId()); break;
                    case "classId": field.set(o,classRepository.findByClassId(fieldVal).getSourcedId()); break;
                    case "enrollmentId": field.set(o,enrollmentRepository.findByEnrollmentId(fieldVal).getSourcedId()); break;
                }

                // We don't want to throw an error if we skip a field due to access failure
                // Original field value will be maintained.
            } catch (IllegalAccessException e){
                System.out.println(e.getMessage());

                // NPE or NFE here just indicates a non-numeric field - Move to the next one!
            } catch (NullPointerException | NumberFormatException e){
                System.out.print("");
            }


        }
        return o;
    }




}
