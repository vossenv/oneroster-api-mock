package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.School;

import java.util.List;

public interface SchoolService {

    School getBySourcedId(String schoolId) throws SchoolNotFoundException;

    List<School> getAllSchools(int offset, int limit) throws SchoolNotFoundException;

}
