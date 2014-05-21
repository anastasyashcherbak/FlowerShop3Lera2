package com.lera.dao;

import com.lera.entity.Holiday;
import com.lera.entity.User;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
public interface HolidaysDAO {
    List<Holiday> find(User user);
    public Holiday find(Integer id);
    Holiday merge(Holiday holiday);
    void delete(Holiday holiday);
}
