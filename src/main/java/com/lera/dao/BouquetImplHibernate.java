package com.lera.dao;

import com.lera.entity.Bouquet;
import com.lera.entity.Holiday;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Михаил on 20.05.14.
 */

@Repository
public class BouquetImplHibernate implements BouquetDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Bouquet> find(Holiday holiday) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Bouquet.class);
        List<Bouquet> bouquets = criteria.add(Restrictions.like("holiday", holiday)).list();
        return bouquets;
    }
}

