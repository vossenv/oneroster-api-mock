package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.Enrollment;

import java.util.List;

public interface EnrollmentService {

    Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException;

    List<Enrollment> getAllEnrollments(int offset, int limit) throws EnrollmentNotFoundException;
    List<Enrollment> getEnrollmentsForSchool(String schoolId, int offset, int limit) throws EnrollmentNotFoundException, SchoolNotFoundException;
    List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId, int offset, int limit) throws
            ClassOfCourseNotFoundException,
            SchoolNotFoundException,
            EnrollmentNotFoundException;

}
