package com.lera.controller;

import com.lera.entity.Flower;
import com.lera.entity.FlowerBank;
import com.lera.service.FlowerBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Created by panser on 5/10/14.
 */
@Controller
@RequestMapping(value = "/flowerBank")
@SessionAttributes({"flower"})
public class FlowerBankController {
    @Autowired
    FlowerBankService flowerBankService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/do"}, method = RequestMethod.GET)
    public String doFlowerBankGET(Model model){
        model.addAttribute("flowerBanks", flowerBankService.findAll());
        model.addAttribute("flower", new Flower());
        return "flowerBank/doFlowerBanks";
    }

    @RequestMapping(value = {"/do"}, method = RequestMethod.POST)
    public String doFlowerBankPOST(@ModelAttribute("flower") Flower flower){
        log.debug(flower.toString());
        FlowerBank flowerBank = new FlowerBank();
        flowerBank.setCount(1);

//        flower.setFlowerBank(flowerBank);
        flowerBank.setFlower(flower);

        flowerBankService.merge(flowerBank);

        return "redirect:/flowerBank/do";
    }

}
