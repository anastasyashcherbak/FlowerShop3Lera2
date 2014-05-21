package com.lera.service;

import com.lera.dao.HolidaysDAO;
import com.lera.entity.Holiday;
import com.lera.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Service
@Transactional
public class HolidayService {
    @Autowired
    HolidaysDAO holidaysDAO;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Transactional(readOnly = true)
    public List<Holiday> find(User user) {
        return holidaysDAO.find(user);
    }

    @Transactional(readOnly = true)
    public Holiday find(Integer id) {
        return holidaysDAO.find(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Holiday merge(Holiday holiday) {
        return holidaysDAO.merge(holiday);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Holiday holiday) {
        holidaysDAO.delete(holiday);
    }

}
