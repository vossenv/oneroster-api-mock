package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

    public User findByUserIdIgnoreCase(String id);
    public User findBySourcedIdIgnoreCase(String id);
    public boolean existsBySourcedIdIgnoreCase(String id);
    public boolean existsBySourcedIdAndRoleIgnoreCase(String id, String role);
}
