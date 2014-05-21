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
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

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
        User user = userService.find(name);
        List<Holiday> holidays = holidayService.find(user);
        model.addAttribute("holidays", holidays);
        model.addAttribute("newHoliday", new Holiday());

        return "/holidays";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
    public String holidayGETById(Model model, @PathVariable String id){
        Holiday holiday = holidayService.find(Integer.parseInt(id));
        log.trace("holidayGETById, holidays = " + holiday);
        model.addAttribute("holiday", holiday);

        return "/bouquets";
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public String holidayPOST(@ModelAttribute("newHoliday") Holiday holiday){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        User user = userService.find(name);
        holiday.assignToUser(user);
        holidayService.merge(holiday);

        return "redirect:/holidays/list";
    }
}
