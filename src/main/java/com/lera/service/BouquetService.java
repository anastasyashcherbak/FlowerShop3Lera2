package com.lera.service;

import com.lera.dao.BouquetDAO;
import com.lera.entity.Bouquet;
import com.lera.entity.Bouquet;
import com.lera.entity.Holiday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Михаил on 20.05.14.
 */
@Service
@Transactional
public class BouquetService {
    @Autowired
    BouquetDAO bouquetDAO;
    private final Logger log = LoggerFactory.getLogger(getClass());


    @Transactional(readOnly = true)
    public List<Bouquet> find(Holiday holiday) {
        return bouquetDAO.find(holiday);
    }

    @Transactional(readOnly = true)
    public Bouquet find(Integer id) {
        return bouquetDAO.find(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Bouquet merge(Bouquet Bouquet) {
        return bouquetDAO.merge(Bouquet);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Bouquet Bouquet) {
        bouquetDAO.delete(Bouquet);
    }

}

