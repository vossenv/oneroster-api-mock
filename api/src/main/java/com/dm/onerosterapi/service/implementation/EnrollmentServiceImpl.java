package com.dm.onerosterapi.service.implementation;

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
    ){
        this.h = h;
        this.rosterDao = rosterDao;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment getEnrollmentById(int enrollmentId) {
        return (Enrollment) h.idFieldSwap(enrollmentRepository.findByEnrollmentId(enrollmentId));
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return (List<Enrollment>) h.idFieldSwap(enrollmentRepository.findAll());
    }

    @Override
    public Enrollment getBySourcedId(String enrollmentId) {
        return (Enrollment) h.idFieldSwap(enrollmentRepository.findBySourcedId(enrollmentId));
    }
}
