package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RosterDaoImpl implements RosterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsersByClass(String classSourcedId) {

        String queryText = "select u from User u join fetch Enrollment e on u.userId=e.userId join fetch " +
                "ClassOfCourse c on e.classId=c.classId where c.sourcedId = " + surround(classSourcedId);

        return (List<User>) entityManager.createQuery(queryText).getResultList();
    }

    public static String surround (String s){
        return "\'" + s + "\'";
    }

}


