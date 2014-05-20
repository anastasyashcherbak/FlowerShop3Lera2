package com.lera.dao;

import com.lera.entity.User;
import com.lera.entity.UserCalendar;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Repository
public class UserImplHibernate implements UserDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public User merge(User user) {
        User userNew = (User)sessionFactory.getCurrentSession().merge(user);
        return userNew;
    }

    @Override
    public User find(String name) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        List<User> userList = criteria.add(Restrictions.like("username", name)).list();
        User user = null;
        if(!userList.isEmpty()){
            user = userList.get(0);
        }
        return user;
    }
}
