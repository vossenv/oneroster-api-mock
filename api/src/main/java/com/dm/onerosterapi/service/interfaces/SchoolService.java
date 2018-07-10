package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.Exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.*;

import java.util.List;

public interface SchoolService {

    public School getBySourcedId(String schoolId) throws SchoolNotFoundException;
    public List<School> getAllSchools() throws SchoolNotFoundException;


}
