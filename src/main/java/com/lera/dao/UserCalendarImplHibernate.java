package com.lera.dao;

import com.lera.entity.Holiday;
import com.lera.entity.User;
import com.lera.entity.UserCalendar;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Repository
public class UserCalendarImplHibernate implements UserCalendarDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public UserCalendar find(User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserCalendar.class);
        log.trace("\nfind, criteria = " + criteria + "\n\n\n");
        List<UserCalendar> userCalendarList = userCalendarList = criteria.add(Restrictions.like("user", user)).list();
        log.trace("userCalendarList = " + userCalendarList + "\n\n\n");
        UserCalendar userCalendar = null;
        if(!userCalendarList.isEmpty()){
            userCalendar = userCalendarList.get(0);
        }
        return userCalendar;
    }
}
