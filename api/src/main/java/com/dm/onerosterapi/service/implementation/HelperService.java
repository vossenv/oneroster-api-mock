package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.*;
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
                    case "schoolId": field.set(o,schoolRepository.findBySchoolIdIgnoreCase(fieldVal).getSourcedId()); break;
                    case "userId": field.set(o,userRepository.findByUserIdIgnoreCase(fieldVal).getSourcedId()); break;
                    case "courseId": field.set(o,courseRepository.findByCourseIdIgnoreCase(fieldVal).getSourcedId()); break;
                    case "classId": field.set(o,classRepository.findByClassIdIgnoreCase(fieldVal).getSourcedId()); break;
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

    public void validateUser(String sourcedId) throws UserNotFoundException{
        if (!userRepository.existsBySourcedIdIgnoreCase(sourcedId)) {throw new UserNotFoundException(ApiMessages.INVALID_USER + sourcedId);}
    }

    public void validateTeacher(String sourcedId) throws UserNotFoundException{
        if (!userRepository.existsBySourcedIdAndRoleIgnoreCase(sourcedId, "teacher")) {throw new UserNotFoundException(ApiMessages.NOT_A_TEACHER + sourcedId);}
    }

    public void validateStudent(String sourcedId) throws UserNotFoundException{
        if (!userRepository.existsBySourcedIdAndRoleIgnoreCase(sourcedId, "student")) {throw new UserNotFoundException(ApiMessages.NOT_A_STUDENT + sourcedId);}
    }

    public void validateClass(String sourcedId) throws ClassOfCourseNotFoundException {
        if (!classRepository.existsBySourcedIdIgnoreCase(sourcedId)) {throw new ClassOfCourseNotFoundException(ApiMessages.INVALID_CLASS + sourcedId);}
    }

    public void validateCourse(String sourcedId) throws CourseNotFoundException {
        if (!courseRepository.existsBySourcedIdIgnoreCase(sourcedId)) {throw new CourseNotFoundException(ApiMessages.INVALID_COURSE + sourcedId);}
    }

    public void validateSchool(String sourcedId) throws SchoolNotFoundException {
        if (!schoolRepository.existsBySourcedIdIgnoreCase(sourcedId)) {throw new SchoolNotFoundException(ApiMessages.INVALID_SCHOOL + sourcedId);}
    }

    public void validateEnrollment(String sourcedId) throws EnrollmentNotFoundException {
        if (!enrollmentRepository.existsBySourcedId(sourcedId)) {throw new EnrollmentNotFoundException(ApiMessages.INVALID_ENROLLMENT + sourcedId);}
    }

    public void validateClassTerm(String term) throws TermNotFoundException {
        if (!classRepository.existsByTermIgnoreCase(term)) {throw new TermNotFoundException(ApiMessages.INVALID_TERM + term);}
    }

}
