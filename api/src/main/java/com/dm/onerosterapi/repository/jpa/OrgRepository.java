package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Org;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepository extends JpaRepository<Org, Integer>{

    public Org findByOrgId(int orgId);

}
