package com.pga.golf.golfer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/api/test1")
    public String test() {
        System.out.println("adfafasfaejfoaej");
        return "test/test";
    }
}
