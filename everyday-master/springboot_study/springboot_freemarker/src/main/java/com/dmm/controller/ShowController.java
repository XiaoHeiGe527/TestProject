package com.dmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DMM
 * @create 2019/7/24
 */
@Controller
public class ShowController {


    @RequestMapping("/index")
    public String ii(Model model){

        model.addAttribute("name","给本次发布会VB ");
        return "show";
    }
}

