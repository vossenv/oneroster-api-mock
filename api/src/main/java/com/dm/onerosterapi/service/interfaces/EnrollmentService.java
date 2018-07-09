package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface EnrollmentService {

    public Enrollment getEnrollmentById(int enrollmentId);
    public Enrollment getBySourcedId(String enrollmentId);
    public List<Enrollment> getAllEnrollments();

}
