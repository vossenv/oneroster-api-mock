package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.SchoolRepository;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired RosterDao rosterDao;
    @Autowired SchoolRepository schoolRepository;

    @Override
    public School getSchoolById(int schoolId) {
        return schoolRepository.findBySchoolId(schoolId);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

}
