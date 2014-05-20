package com.lera.service;

import com.lera.dao.UserDAO;
import com.lera.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by panser on 5/18/14.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional(rollbackFor = Exception.class)
    public User merge(User user) {
        User userNew = userDAO.merge(user);
        return userNew;
    }

    @Transactional(readOnly = true)
    public User find(String name) {
        User user = userDAO.find(name);
        return user;
    }
}
