package com.lera.dao;

import com.lera.entity.User;

/**
 * Created by panser on 5/18/14.
 */
public interface UserDAO {
    User merge(User user);
    User find(String name);
}
