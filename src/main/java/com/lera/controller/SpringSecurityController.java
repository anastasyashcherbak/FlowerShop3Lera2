package com.lera.controller;

import com.lera.entity.User;
import com.lera.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by panser on 5/18/14.
 */
@Controller
@RequestMapping(value = "/user")
public class SpringSecurityController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(){
        return "user/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET(Model model){
        model.addAttribute("user", new User());
        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPOST(@ModelAttribute("user") User userFromForm, BindingResult result){
        User user = new User();
        user.setUsername(userFromForm.getUsername());
        user.setPassword(userFromForm.getPassword());
        String viewName;
        if(result.hasErrors()){
            viewName = "user/register";
        }
        else
        {
            userService.merge(user);
            viewName = "redirect:/user/login";
        }
        return viewName;
    }

}
