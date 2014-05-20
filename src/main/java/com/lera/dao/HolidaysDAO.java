package com.lera.dao;

import com.lera.entity.Holiday;
import com.lera.entity.UserCalendar;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
public interface HolidaysDAO {
    List<Holiday> find(UserCalendar userCalendar);
}
