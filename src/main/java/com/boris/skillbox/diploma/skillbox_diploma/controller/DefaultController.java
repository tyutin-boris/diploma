package com.boris.skillbox.diploma.skillbox_diploma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DefaultController {

    public String index() {
        return "index";
    }
}
