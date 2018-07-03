package com.dm.onerosterapi.Service;

import com.dm.onerosterapi.model.User;

import java.util.List;

public interface SchoolService {

    User findByUserId(String userId);
    List<User> findByRole(String role);

}
