package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

    public User findByUserId(String id);
    public User findBySourcedId(String id);
    public boolean existsBySourcedId(String id);
}
