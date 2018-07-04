package com.dm.onerosterapi.Service;

import com.dm.onerosterapi.model.User;

import java.util.List;

public interface RosterService {

    User getUserById(int userId);

    List<User> getAllUsers();


}
