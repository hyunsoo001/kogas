package com.atg.kogas.controller;


import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.SurveyQuestion;
import com.atg.kogas.service.SurveyQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SurveyQuestionController {

    private final SurveyQuestionService surveyQuestionService;

    @GetMapping("/surveyQuestions")
    public String findAll(Model model) {
//        List<SurveyQuestion> surveyQuestions = surveyQuestionService.findAll();
//        model.addAttribute("surveyQuestions",surveyQuestions);
        return "surveyQuestions/surveyQuestion";
    }


    @GetMapping("/surveyQuestions/findOne")
    public String findOne(Model model, String facilityName3) {
        SurveyQuestion surveyQuestions = surveyQuestionService.findOne(facilityName3);
        model.addAttribute("surveyQuestions", surveyQuestions);
        //model.addAttribute("facilityName",facilityName);
        return "surveyQuestions/surveyQuestion";
    }

//    @PostMapping("/surveyQuestions")
//    public String create(@RequestBody SurveyQuestion parameter){
//        surveyQuestionService.create(parameter);
//        return "surveyQuestions/surveyQuestion";
//    }

    @PostMapping("/surveyQuestions")
    public String update(@RequestBody SurveyQuestion parameter) {
        surveyQuestionService.update(parameter);
        return "surveyQuestions/surveyQuestion";
    }

    @GetMapping("/surveyQuestions/page3")
    public String findOne22() {
//        SurveyQuestion surveyQuestions = surveyQuestionService.findOne(facilityName);
//        model.addAttribute("surveyQuestions", surveyQuestions);
        return "surveyQuestions/page3";
    }

}
