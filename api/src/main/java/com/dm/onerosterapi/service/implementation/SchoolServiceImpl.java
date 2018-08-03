package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.SchoolRepository;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.AttributeTransformer;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class SchoolServiceImpl implements SchoolService {

    final private AttributeTransformer h;
    final private SchoolRepository schoolRepository;
    final private RosterDao rosterDao;

    @Inject
    public SchoolServiceImpl(
            SchoolRepository schoolRepository,
            AttributeTransformer h,
            RosterDao rosterDao
    ) {
        this.schoolRepository = schoolRepository;
        this.h = h;
        this.rosterDao = rosterDao;
    }

    @Override
    public List<School> getAllSchools(int offset, int limit) throws SchoolNotFoundException {
        try {
            return (List<School>) h.processResults(rosterDao.getAll(AllowedTypes.School, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new SchoolNotFoundException(ApiMessageConfig.NO_RESULTS);
        }
    }

    @Override
    public School getBySourcedId(String schoolId) throws SchoolNotFoundException {
        try {
            return (School) h.processResults(schoolRepository.findBySourcedIdIgnoreCase(schoolId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new SchoolNotFoundException(ApiMessageConfig.NO_SCHOOLS_FOR_ID + schoolId);
        }
    }
}
