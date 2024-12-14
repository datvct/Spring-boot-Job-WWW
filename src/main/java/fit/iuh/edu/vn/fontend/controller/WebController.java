package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/introduce")
    public String showAboutPage() {
        return "introduce";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
}
