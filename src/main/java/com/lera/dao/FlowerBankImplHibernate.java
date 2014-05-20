package com.lera.dao;

import com.lera.entity.Flower;
import com.lera.entity.FlowerBank;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by panser on 5/10/14.
 */
@Repository
public class FlowerBankImplHibernate implements FlowerBankDAO {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public FlowerBank find(Integer id) {
        FlowerBank flowerBank = (FlowerBank) sessionFactory.getCurrentSession().get(FlowerBank.class, id);
        return flowerBank;
    }

    @Override
    public List<FlowerBank> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FlowerBank.class);
        List results = criteria.list();
        return results;
    }

    @Override
    public FlowerBank merge(FlowerBank flowerBank) {
        FlowerBank flowerBankNew = (FlowerBank)sessionFactory.getCurrentSession().merge(flowerBank);
        return flowerBankNew;
    }

    @Override
    public void delete(FlowerBank flowerBank) {
        sessionFactory.getCurrentSession().delete(flowerBank);
    }
}
