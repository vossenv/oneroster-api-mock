package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface EnrollmentService {

    public Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException;
    public List<Enrollment> getAllEnrollments() throws EnrollmentNotFoundException;
    public List<Enrollment> getEnrollmentsForSchool(String schoolId) throws EnrollmentNotFoundException, SchoolNotFoundException;
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId) throws
            ClassOfCourseNotFoundException,
            SchoolNotFoundException,
            EnrollmentNotFoundException;

}
