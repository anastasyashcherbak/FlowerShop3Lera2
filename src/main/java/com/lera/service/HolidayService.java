package com.lera.service;

import com.lera.dao.HolidaysDAO;
import com.lera.dao.UserCalendarDAO;
import com.lera.entity.Holiday;
import com.lera.entity.User;
import com.lera.entity.UserCalendar;
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
    UserCalendarDAO userCalendarDAO;
    @Autowired
    HolidaysDAO holidaysDAO;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Transactional(readOnly = true)
    public List<Holiday> find(User user) {
        UserCalendar userCalendar = userCalendarDAO.find(user);
        return holidaysDAO.find(userCalendar);
    }
}
