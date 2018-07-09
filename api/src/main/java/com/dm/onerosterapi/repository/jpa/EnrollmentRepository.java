package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String>{

    public Enrollment findByEnrollmentId(String enrollmentId);
    public Enrollment findBySourcedId(String enrollmentId);

}
