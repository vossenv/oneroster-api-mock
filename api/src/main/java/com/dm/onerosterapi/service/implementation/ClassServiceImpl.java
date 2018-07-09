package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.ClassRepository;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unchecked")
public class ClassServiceImpl implements ClassService {

    private HelperService h;
    private RosterDao rosterDao;
    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(
            RosterDao rosterDao,
            ClassRepository classRepository,
            HelperService h
    ){
        this.rosterDao = rosterDao;
        this.classRepository = classRepository;
        this.h = h;
    }


    @Override
    public ClassOfCourse getClassById(String classId) {
        return (ClassOfCourse) h.idFieldSwap(classRepository.findByClassId(classId));
    }

    @Override
    public List<ClassOfCourse> getAllClasses() {
        return (List<ClassOfCourse>) h.idFieldSwap(classRepository.findAll());
    }

    @Override
    public ClassOfCourse getBySourcedId(String classId) {
        return (ClassOfCourse) h.idFieldSwap(classRepository.findBySourcedId(classId));
    }

}
