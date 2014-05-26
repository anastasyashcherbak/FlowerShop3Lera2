package com.lera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Михаил on 23.05.14.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(){
        return "redirect:/holidays/list";
    }

    @RequestMapping(value = {"/timeout"}, method = RequestMethod.GET)
    public String timeout(){
        return "redirect:/";
    }
}
