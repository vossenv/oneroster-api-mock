package com.dm.onerosterapi.repository.jpa;

import com.dm.onerosterapi.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findByUserIdIgnoreCase(String id);
    User findBySourcedIdIgnoreCase(String id);
    boolean existsBySourcedIdIgnoreCase(String id);
    boolean existsBySourcedIdAndRoleIgnoreCase(String id, String role);

}
