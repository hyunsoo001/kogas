package com.atg.kogas.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@Slf4j
public class HomeController {
    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "facilityBaseInfos/facilityBaseInfoList";
    }

    @RequestMapping("/upload")
    public String upload() {
        log.info("home controller");
        return "/index";
    }

//    @RequestMapping("/upload")
//    public String home2() {
//        log.info("home controller");
//        return "/index";
//    }
}
