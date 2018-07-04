package com.dm.onerosterapi.repository.dao;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RosterDaoImpl implements RosterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    public ClassOfCourse getClassById(int classId) {
        return entityManager.find(ClassOfCourse.class, classId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ClassOfCourse> getAllClasses() {
        return (List<ClassOfCourse>) entityManager.createQuery("from ClasOfCourse").getResultList();
    }

}


// Old
// String hql = "from ClassOfCourse c where c.classId = " + classId;
// return (ClassOfCourse) entityManager.createQuery(hql).getSingleResult();
// String hql = "from User u join fetch u.enrollmentList where u.userId = " + userId;
// String hql = "from User u join fetch u.enrollmentList";
// String hql = "from ClassOfCourse c join fetch c.classofcourse where c.classId = " + classId;
