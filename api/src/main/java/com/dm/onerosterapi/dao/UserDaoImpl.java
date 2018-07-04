package com.dm.onerosterapi.dao;

import com.dm.onerosterapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {

        String hql = "FROM User";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
}
