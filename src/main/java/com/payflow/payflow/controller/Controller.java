package com.payflow.payflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
public class Controller {
    @GetMapping
    public static String sayHello() {
        return "Hello user! How are you? Welcome!";
    }
}
