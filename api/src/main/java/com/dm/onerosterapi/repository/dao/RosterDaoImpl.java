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

        String hql = "from User u join fetch u.enrollmentList where u.userId = " + userId;
        return (User) entityManager.createQuery(hql).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {

        String hql = "from User u join fetch u.enrollmentList";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public ClassOfCourse getClassById(int classId) {

        String hql = "from ClassOfCourse c join fetch c.classofcourse where c.classId = " + classId;
        return (ClassOfCourse) entityManager.createQuery(hql).getSingleResult();
    }


}
