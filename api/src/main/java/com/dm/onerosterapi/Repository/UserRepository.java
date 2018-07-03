package com.dm.onerosterapi.Repository;

import com.dm.onerosterapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByUserId(String userId);
    List<User> findByRole(String role);

}
