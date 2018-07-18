package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.utility.ApiMessages;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.repository.jpa.SchoolRepository;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.utility.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class SchoolServiceImpl implements SchoolService {

    private HelperService h;
    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(
            SchoolRepository schoolRepository,
            HelperService h
    ) {
        this.schoolRepository = schoolRepository;
        this.h = h;
    }

    @Override
    public List<School> getAllSchools() throws SchoolNotFoundException {
        try {
            return (List<School>) h.processResults(schoolRepository.findAll());
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new SchoolNotFoundException(ApiMessages.NO_RESULTS);
        }
    }

    @Override
    public School getBySourcedId(String schoolId) throws SchoolNotFoundException {
        try {
            return (School) h.processResults(schoolRepository.findBySourcedIdIgnoreCase(schoolId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new SchoolNotFoundException(ApiMessages.NO_SCHOOLS_FOR_ID + schoolId);
        }
    }
}
