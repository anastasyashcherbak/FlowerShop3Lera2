package com.lera.controller;

import com.lera.entity.Bouquet;
import com.lera.entity.Holiday;
import com.lera.entity.User;
import com.lera.service.BouquetService;
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
 * Created by Михаил on 20.05.14.
 */

@Controller
@RequestMapping(value = "/bouquets")
@SessionAttributes({"bouquet"})
public class BouquetController {
    @Autowired
    BouquetService bouquetService;
    @Autowired
    HolidayService holidayService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/get/{id}"}, method = RequestMethod.GET, produces = {MediaType.TEXT_HTML_VALUE})
    public String bouquetGET(Model model, @PathVariable String id){
        log.trace("bouquetGET(), id " + id + "/n");
        Holiday holiday = holidayService.find(Integer.parseInt(id));

        List<Bouquet> bouquets = bouquetService.find(holiday);
        model.addAttribute("bouquets", bouquets);

        return "/bouquets";
    }
}

