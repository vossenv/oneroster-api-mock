package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.repository.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    private final static String NO_RESULTS_MESSAGE = "Search returned no results...";

    public List<?> processResults(List<?> objectList) throws ResourceNotFoundException{

        if (objectList == null || objectList.isEmpty()) { throw new ResourceNotFoundException(NO_RESULTS_MESSAGE) ; }
        for (Object o : objectList){ processResults(o); }
        return objectList;
    }

    public Object processResults(Object o) throws ResourceNotFoundException{

        if (o == null) { throw new ResourceNotFoundException(NO_RESULTS_MESSAGE) ; }

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
            } catch (IllegalAccessException | DataIntegrityViolationException e) {
                System.out.println(e.getMessage());

            // NPE indicates a null field - Move to the next one!
            } catch (NullPointerException e){
                System.out.print("");
            }
        }
        return o;
    }







}
