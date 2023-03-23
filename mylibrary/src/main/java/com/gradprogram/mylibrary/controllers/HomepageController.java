package com.gradprogram.mylibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homePage(ModelMap model) {
        return "index";
    }
}
