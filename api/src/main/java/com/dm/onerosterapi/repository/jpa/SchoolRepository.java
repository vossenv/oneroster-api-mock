package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, String>{

    School findBySchoolIdIgnoreCase(String id);
    School findBySourcedIdIgnoreCase(String id);
    boolean existsBySourcedIdIgnoreCase(String id);

}
