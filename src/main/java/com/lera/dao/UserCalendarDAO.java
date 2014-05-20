package com.lera.dao;

import com.lera.entity.User;
import com.lera.entity.UserCalendar;

/**
 * Created by panser on 5/18/14.
 */
public interface UserCalendarDAO {
    UserCalendar find(User user);
}
