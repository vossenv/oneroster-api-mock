package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.apiconfig.ApiMessageConfig;
import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.exceptions.ResourceNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.EnrollmentRepository;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.utility.AllowedTypes;
import com.dm.onerosterapi.utility.AttributeTransformer;
import com.dm.onerosterapi.utility.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class EnrollmentServiceImpl implements EnrollmentService {

    private AttributeTransformer h;
    private Validator v;
    private RosterDao rosterDao;
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(
            RosterDao rosterDao,
            EnrollmentRepository enrollmentRepository,
            AttributeTransformer h,
            Validator v
    ) {
        this.v = v;
        this.h = h;
        this.rosterDao = rosterDao;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> getAllEnrollments(int offset, int limit) throws EnrollmentNotFoundException {
        try {
            return (List<Enrollment>) h.processResults(rosterDao.getAll(AllowedTypes.Enrollment, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessageConfig.NO_RESULTS);
        }
    }

    @Override
    public Enrollment getBySourcedId(String enrollmentId) throws EnrollmentNotFoundException {
        try {
            return (Enrollment) h.processResults(enrollmentRepository.findBySourcedId(enrollmentId));
        } catch (NullPointerException | ResourceNotFoundException e) {
            throw new EnrollmentNotFoundException(ApiMessageConfig.NO_ENROLLMENTS_FOR_ID);
        }
    }


    @Override
    public List<Enrollment> getEnrollmentsForSchool(String schoolId, int offset, int limit) throws EnrollmentNotFoundException, SchoolNotFoundException {
        try {
            v.validateSchool(schoolId);
            return (List<Enrollment>) h.processResults(rosterDao.getEnrollmentsBySchool(schoolId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessageConfig.NO_RESULTS);
        }

    }

    @Override
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId, int offset, int limit) throws
            EnrollmentNotFoundException,
            SchoolNotFoundException,
            ClassOfCourseNotFoundException {

        try {
            v.validateClass(classId);
            v.validateSchool(schoolId);
            return (List<Enrollment>) h.processResults(rosterDao.getEnrollmentsForClassInSchool(classId, schoolId, offset, limit));
        } catch (NullPointerException | ResourceNotFoundException e){
            throw new EnrollmentNotFoundException(ApiMessageConfig.NO_RESULTS);
        }
    }
}
