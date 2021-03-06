package com.ggomjae.com.statistics.controller;

import com.ggomjae.com.statistics.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/hello")
    public String homeMethod(Map model){
        model.put("message", "hello freemarker!");
        return "common/hello";
    }

    @GetMapping("/statistic")
    public String statisticMethod(Map model){
        model.put("message", "hello freemarker!");
        return "statisticsResult";
    }

    @GetMapping("/pie")
    public String pieMethod(){
        return "pieView";
    }

    @GetMapping(path="/excel", produces = "application/vnd.ms-excel")
    public String downloadExcel() {

        return "sampleXls";
    }

    @PostMapping("/posts")
    public void createPost() throws ParseException {

        homeService.createPost();
    }
}
