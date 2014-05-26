package com.lera.controller;

import com.lera.entity.Bouquet;
import com.lera.entity.Flower;
import com.lera.entity.FlowerBank;
import com.lera.entity.Holiday;
import com.lera.service.BouquetService;
import com.lera.service.FlowerBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by panser on 5/10/14.
 */
@Controller
@RequestMapping(value = "/flowerBank")
public class FlowerBankController {
    @Autowired
    FlowerBankService flowerBankService;
    @Autowired
    BouquetService bouquetService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/get/{Bouquetid}"}, method = RequestMethod.GET)
    public String flowerBankGET(Model model, @PathVariable String Bouquetid){
        Bouquet bouquet = bouquetService.find(Integer.parseInt(Bouquetid));
        List<FlowerBank> flowerBanks = flowerBankService.find(bouquet);

        model.addAttribute("flowerBanks", flowerBanks);
        model.addAttribute("flower", new Flower());
        model.addAttribute("flowerBank", new FlowerBank());
        return "flowerBank";
    }

    @RequestMapping(value = {"/get/{Bouquetid}"}, method = RequestMethod.POST)
    public String flowerBankPOST(@ModelAttribute("flower") Flower flower,@ModelAttribute("flowerBank") FlowerBank flowerBank,
                                 @PathVariable String Bouquetid){
        Bouquet bouquet = bouquetService.find(Integer.parseInt(Bouquetid));

        flowerBank.setFlower(flower);
        flowerBank.setBouquet(bouquet);

        flowerBankService.merge(flowerBank);

        return "redirect:/flowerBank/get/" + Bouquetid;
    }


    @RequestMapping(value = {"/edit/{FlowerBankId}"}, method = RequestMethod.GET)
    public String flowerBankEditGET(Model model,@PathVariable String FlowerBankId){
        FlowerBank flowerBankEdit = flowerBankService.find(Integer.parseInt(FlowerBankId));
        Bouquet bouquet = flowerBankEdit.getBouquet();
        List<FlowerBank> flowerBanks = flowerBankService.find(bouquet);

        model.addAttribute("flowerBanks", flowerBanks);

        model.addAttribute("flower", flowerBankEdit.getFlower());
        model.addAttribute("flowerBank", flowerBankEdit);

        return "flowerBank";
    }

    @RequestMapping(value = {"/edit/{FlowerBankId}"}, method = RequestMethod.POST)
    public String flowerBankEditPOST(@ModelAttribute("flower") Flower flower,@ModelAttribute("flowerBank") FlowerBank flowerBank,
                                 @PathVariable String FlowerBankId){
        FlowerBank flowerBankEdit = flowerBankService.find(Integer.parseInt(FlowerBankId));
        flowerBankEdit.setCount(flowerBank.getCount());
        log.trace("flowerBankEditPOST, flowerBankEdit:" + flowerBankEdit);
        Bouquet bouquet = flowerBankEdit.getBouquet();
        log.trace("flowerBankEditPOST, bouquet:" + bouquet);
        Integer bouquetId = bouquet.getId();

        flowerBankEdit.getFlower().setColor(flower.getColor());
        flowerBankEdit.getFlower().setName(flower.getName());

        flowerBankService.merge(flowerBankEdit);

        return "redirect:/flowerBank/get/" + bouquetId;
    }

    @RequestMapping(value = {"/delete/{HolidayId}"}, method = RequestMethod.GET)
    public String flowerBankDeleteGET(@PathVariable String HolidayId){
        FlowerBank flowerBankEdit = flowerBankService.find(Integer.parseInt(HolidayId));
        flowerBankService.delete(flowerBankEdit);

        return "redirect:/";
    }

}
