package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.*;
import com.dm.onerosterapi.utility.AllowedTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@SuppressWarnings("unchecked")
public class RosterDaoImpl implements RosterDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static String surround(String s) {
        return "\'" + s.toLowerCase() + "\'";
    }

    private static String setRole(String role) {
        if (role.equals("student") || role.equals("teacher")) {
            return " and u.role = " + surround(role);
        } else return "";
    }

    @Override
    public List<User> getUsersByClass(String sourcedId, String role, int offset, int limit) {

        String queryText = "select u from User u join fetch Enrollment e on u.userId=e.userId join fetch " +
                "ClassOfCourse c on e.classId=c.classId where c.sourcedId = "
                + surround(sourcedId) + setRole(role);

        return (List<User>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<ClassOfCourse> getClassesByUser(String sourcedId, String role, int offset, int limit) {

        String queryText = "select c from ClassOfCourse c join fetch Enrollment e on c.classId=e.classId join fetch " +
                "User u on e.userId=u.userId where u.sourcedId = " + surround(sourcedId) + setRole(role);

        return (List<ClassOfCourse>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<ClassOfCourse> getClassesByTerm(String term, int offset, int limit) {
        String queryText = "select c from ClassOfCourse c " +
                "where lower(c.term) = " + surround(term.toLowerCase());

        return (List<ClassOfCourse>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<ClassOfCourse> getClassesByCourse(String sourcedId, int offset, int limit) {
        String queryText = "select c from ClassOfCourse c join fetch Course co on c.courseId=co.courseId " +
                "where co.sourcedId = " + surround(sourcedId);

        return (List<ClassOfCourse>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<ClassOfCourse> getClassesBySchool(String sourcedId, int offset, int limit) {
        String queryText = "select c from ClassOfCourse c join fetch School s on c.schoolId=s.schoolId " +
                "where s.sourcedId = " + surround(sourcedId);

        return (List<ClassOfCourse>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<Course> getCoursesBySchool(String sourcedId, int offset, int limit) {
        String queryText = "select c from Course c join fetch School s on c.schoolId=s.schoolId " +
                "where s.sourcedId = " + surround(sourcedId);

        return (List<Course>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<Enrollment> getEnrollmentsBySchool(String sourcedId, int offset, int limit) {
        String queryText = "select e from Enrollment e join fetch ClassOfCourse c on e.classId=c.classId " +
                "join fetch School s on c.schoolId=s.schoolId " +
                "where s.sourcedId = " + surround(sourcedId);

        return (List<Enrollment>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<User> getUsersBySchool(String sourcedId, String role, int offset, int limit) {
        String queryText = "select u from User u join fetch School s on u.schoolId=s.schoolId " +
                "where s.sourcedId = " + surround(sourcedId) + setRole(role);

        return (List<User>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<Enrollment> getEnrollmentsForClassInSchool(String classId, String schoolId, int offset, int limit) {
        String queryText = "select e from Enrollment e join fetch ClassOfCourse c on e.classId=c.classId " +
                "join fetch School s on c.schoolId=s.schoolId " +
                "where s.sourcedId = " + surround(schoolId) + " " +
                "and c.sourcedId = " + surround(classId);

        return (List<Enrollment>) entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<User> getUsersForClassInSchool(String classId, String schoolId, String role, int offset, int limit) {
        String queryText = "select u from User u join fetch School s on u.schoolId=s.schoolId " +
                "join fetch Enrollment e on e.userId = u.userId " +
                "join fetch ClassOfCourse c on c.classId = e.classId " +
                "where s.sourcedId = " + surround(schoolId) + " " +
                "and c.sourcedId = " + surround(classId) +
                setRole(role);

        return entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<?> getAll(AllowedTypes type, int offset, int limit) {

        String queryText = "from " + type.toString();
        return entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    @Override
    public List<User> getAllUsersOfType(String role, int offset, int limit) {

        String queryText = "select u from User u where 1 = 1" + setRole(role);
        return entityManager
                .createQuery(queryText)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }
}


