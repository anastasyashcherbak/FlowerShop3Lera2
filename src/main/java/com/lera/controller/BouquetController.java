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
    @Autowired
    UserService userService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/get/{id}"}, method = RequestMethod.GET)
    public String bouquetGET(Model model, @PathVariable String id){
        log.trace("bouquetGET(), id " + id + "/n");
        Holiday holiday = holidayService.find(Integer.parseInt(id));
        List<Bouquet> bouquets = bouquetService.find(holiday);

        model.addAttribute("bouquets", bouquets);
        model.addAttribute("bouquet", new Bouquet());

        return "/bouquets";
    }

    @RequestMapping(value = {"/get/{id}"}, method = RequestMethod.POST)
    public String holidayPOST(@ModelAttribute("bouquet") Bouquet bouquet, @PathVariable String id){
        Holiday holiday = holidayService.find(Integer.parseInt(id));
        bouquet.setHoliday(holiday);
        bouquetService.merge(bouquet);

        return "redirect:/bouquets/get/" + id;
    }

    @RequestMapping(value = {"/edit/{BouquetId}"}, method = RequestMethod.GET)
    public String flowerBankEditGET(Model model,@PathVariable String BouquetId){
        Bouquet bouquetEdit = bouquetService.find(Integer.parseInt(BouquetId));
        Holiday holiday = bouquetEdit.getHoliday();
        List<Bouquet> bouquets = bouquetService.find(holiday);

        model.addAttribute("bouquets", bouquets);

        model.addAttribute("bouquet", bouquetEdit);

        return "bouquets";
    }

    @RequestMapping(value = {"/edit/{BouquetId}"}, method = RequestMethod.POST)
    public String flowerBankEditPOST(@ModelAttribute("bouquet") Bouquet bouquet,
                                     @PathVariable String BouquetId){
        Bouquet bouquetEdit = bouquetService.find(Integer.parseInt(BouquetId));
        bouquetEdit.setName(bouquet.getName());

        Holiday holiday = bouquetEdit.getHoliday();
        Integer holidayId = holiday.getId();

        bouquetService.merge(bouquetEdit);

        return "redirect:/bouquets/get/" + holidayId;
    }

    @RequestMapping(value = {"/delete/{HolidayId}"}, method = RequestMethod.GET)
    public String flowerBankDeleteGET(@PathVariable String HolidayId){
        Bouquet bouquetEdit = bouquetService.find(Integer.parseInt(HolidayId));
        bouquetService.delete(bouquetEdit);

        return "redirect:/";
    }

}

