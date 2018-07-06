package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.SchoolRepository;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class SchoolServiceImpl implements SchoolService {

    private HelperService h;
    private RosterDao rosterDao;
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(
            RosterDao rosterDao,
            SchoolRepository schoolRepository,
            HelperService h
    ){
        this.rosterDao = rosterDao;
        this.schoolRepository = schoolRepository;
        this.h = h;
    }

    @Override
    public School getSchoolById(int schoolId) {
        return (School) h.idFieldSwap(schoolRepository.findBySchoolId(schoolId));
    }

    @Override
    public List<School> getAllSchools() {
        return (List<School>) h.idFieldSwap(schoolRepository.findAll());
    }

}
