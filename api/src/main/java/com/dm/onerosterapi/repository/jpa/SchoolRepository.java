package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, String>{

    public School findBySchoolId(String schoolId);
    public School findBySourcedId(String schoolId);

}
