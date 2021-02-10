package com.ggomjae.com.statistics.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    @GetMapping("/home")
    public String homeMethod(){

        return "GGOMJAE";
    }
}
