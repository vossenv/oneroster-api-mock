package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface EnrollmentService {

    public Enrollment getBySourcedId(String enrollmentId);
    public List<Enrollment> getAllEnrollments();
    public List<Enrollment> getEnrollmentsForSchool(String schoolId);
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId);

}
