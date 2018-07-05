package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer>{

    public School findBySchoolId(int schoolId);

}
