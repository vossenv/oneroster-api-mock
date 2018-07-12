package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.exceptions.*;
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
            return (List<Enrollment>) h.processResults(enrollmentRepository.findAll());
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessages.NO_RESULTS);
        }
    }

    @Override
    public Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException {
        try {
            return (Enrollment) h.processResults(enrollmentRepository.findBySourcedId(enrollmentId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new EnrollmentNotFoundException(ApiMessages.NO_ENROLLMENTS_FOR_ID);
        }
    }


    @Override
    public List<Enrollment> getEnrollmentsForSchool(String schoolId) throws EnrollmentNotFoundException, SchoolNotFoundException {
        try {
            h.validateSchool(schoolId);
            return (List<Enrollment>) h.processResults(rosterDao.getEnrollmentsBySchool(schoolId));
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessages.NO_RESULTS);
        }

    }

    @Override
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId) throws
            EnrollmentNotFoundException,
            SchoolNotFoundException,
            ClassOfCourseNotFoundException {

        try {
            h.validateClass(classId);
            h.validateSchool(schoolId);
            return (List<Enrollment>) h.processResults(rosterDao.getEnrollmentsForClassInSchool(classId, schoolId));
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessages.NO_RESULTS);
        }
    }
}
