package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface SchoolService {

    public School getBySourcedId(String schoolId);
    public List<School> getAllSchools();


}
