package com.lera.dao;

import com.lera.entity.Holiday;
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
public class HolidayImplHibernate implements HolidaysDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Holiday> find(UserCalendar userCalendar) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Holiday.class);
        List<Holiday> holidays = criteria.add(Restrictions.like("userCalendar", userCalendar)).list();
        return holidays;
    }
}
