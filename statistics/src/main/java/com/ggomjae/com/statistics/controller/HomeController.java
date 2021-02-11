package com.ggomjae.com.statistics.controller;

import com.ggomjae.com.statistics.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/home")
    public String homeMethod(){

        return "GGOMJAE";
    }

    @PostMapping("/posts")
    public void createPost(){

        homeService.createPost();
    }
}
