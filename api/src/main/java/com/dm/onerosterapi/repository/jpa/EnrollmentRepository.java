package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, String>{

    Enrollment findByEnrollmentId(String id);
    Enrollment findBySourcedId(String id);
    boolean existsBySourcedId(String id);

}
