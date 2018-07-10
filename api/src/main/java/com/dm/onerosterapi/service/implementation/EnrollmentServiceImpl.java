package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.EnrollmentRepository;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EnrollmentServiceImpl implements EnrollmentService {

    private HelperService h;
    private RosterDao rosterDao;
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(
            RosterDao rosterDao,
            EnrollmentRepository enrollmentRepository,
            HelperService h
    ) {
        this.h = h;
        this.rosterDao = rosterDao;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> getAllEnrollments() throws EnrollmentNotFoundException {
        try {
            return (List<Enrollment>) h.idFieldSwap(enrollmentRepository.findAll());
        } catch (NullPointerException e) {
            throw new EnrollmentNotFoundException("Search returned no results..." + e.getMessage());
        }
    }

    @Override
    public Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException {
        try {
            return (Enrollment) h.idFieldSwap(enrollmentRepository.findBySourcedId(enrollmentId));
        } catch (NullPointerException e) {
            throw new EnrollmentNotFoundException("Search returned no results..." + e.getMessage());
        }
    }


    @Override
    public List<Enrollment> getEnrollmentsForSchool(String schoolId) throws EnrollmentNotFoundException {
        try {
            return (List<Enrollment>) h.idFieldSwap(rosterDao.getEnrollmentsBySchool(schoolId));
        } catch (NullPointerException e) {
            throw new EnrollmentNotFoundException("Search returned no results..." + e.getMessage());
        }

    }

    @Override
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId) throws EnrollmentNotFoundException {
        try {
            return (List<Enrollment>) h.idFieldSwap(rosterDao.getEnrollmentsForClassInSchool(classId, schoolId));
        } catch (NullPointerException e) {
            throw new EnrollmentNotFoundException("Search returned no results..." + e.getMessage());
        }
    }
}
