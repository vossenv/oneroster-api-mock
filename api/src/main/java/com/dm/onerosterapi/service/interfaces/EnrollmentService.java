package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions1.EnrollmentNotFoundException;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface EnrollmentService {

    public Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException;
    public List<Enrollment> getAllEnrollments() throws EnrollmentNotFoundException;
    public List<Enrollment> getEnrollmentsForSchool(String schoolId) throws EnrollmentNotFoundException;
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId) throws EnrollmentNotFoundException;

}
