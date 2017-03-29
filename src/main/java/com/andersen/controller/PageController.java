package com.andersen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String indexPage(Model model) {
        System.out.println("I WORK!!!");
        return "home.xhtml";
    }
}
