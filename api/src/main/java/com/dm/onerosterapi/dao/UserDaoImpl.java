package com.dm.onerosterapi.dao;

import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(int userId) {

        String hql = "from User u join fetch u.enrollmentList where u.userId = " + userId;
        return (User) entityManager.createQuery(hql).getSingleResult();

        // return entityManager.find(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {

        // String hql = "from User u join fetch u.enrollmentList";
        String hql = "From User";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
}
