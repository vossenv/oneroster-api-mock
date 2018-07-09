package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository
@SuppressWarnings("unchecked")
public class RosterDaoImpl implements RosterDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static String surround (String s){
        return "\'" + s + "\'";
    }

    @Override
    public List<User> getUsersByClass(String classSourcedId) {

        String queryText = "select u from User u join fetch Enrollment e on u.userId=e.userId join fetch " +
                "ClassOfCourse c on e.classId=c.classId where c.sourcedId = " + surround(classSourcedId);

        return (List<User>) entityManager.createQuery(queryText).getResultList();
    }

    @Override
    public List<ClassOfCourse> getClassesByUser(String userSourcedId, String role) {

        String roleString;

        if (role.equals("student") || role.equals("teacher")){
            roleString = " and u.role = " + surround(role);
        } else {
            roleString = "";
        }


        String queryText = "select c from ClassOfCourse c join fetch Enrollment e on c.classId=e.classId join fetch " +
                "User u on e.userId=u.userId where u.sourcedId = " + surround(userSourcedId) + roleString;

        return (List<ClassOfCourse>) entityManager.createQuery(queryText).getResultList();
    }

}


