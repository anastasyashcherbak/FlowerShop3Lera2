package com.lera.controller;

import com.lera.entity.Holiday;
import com.lera.entity.User;
import com.lera.service.HolidayService;
import com.lera.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by panser on 5/18/14.
 */
@Controller
@RequestMapping(value = "/holidays")
@SessionAttributes({"holiday"})
public class HolidayController {
    @Autowired
    HolidayService holidayService;
    @Autowired
    UserService userService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String holidaysGET(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        log.trace("holidaysGET, name = " + name);
        User user = userService.find(name);
        log.trace("holidaysGET, user = " + user);
        List<Holiday> holidays = holidayService.find(user);
        log.trace("holidaysGET, holidays = " + holidays);
        model.addAttribute("holidays", holidays);

        return "/holidays";
    }
}
