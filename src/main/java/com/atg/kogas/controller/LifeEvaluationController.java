package com.atg.kogas.controller;

import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.LifeEvaluation;
import com.atg.kogas.domain.SurveyQuestion;
import com.atg.kogas.service.FacilityBaseInfoService;
import com.atg.kogas.service.LifeEvaluationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LifeEvaluationController {

    private final LifeEvaluationService lifeEvaluationService;

    @GetMapping("/lifeEvaluations")
    public String findAll(Model model) {
//        List<FacilityEvaluationGrade> facilityEvaluationGrades = facilityEvaluationGradeService.findAll();
//        model.addAttribute("facilityEvaluationGrades",facilityEvaluationGrades);
        return "lifeEvaluations/lifeEvaluation";
    }

    @GetMapping("/lifeEvaluations/findOne")
    public String findOne(Model model, String invenName, String locateName, String facilityName, String installCode) {
        List<FacilityEvaluationGrade>  facilityEvaluationGrades = lifeEvaluationService.findOneGrade(invenName,locateName,facilityName,installCode);
        List<SurveyQuestion> surveyQuestions = lifeEvaluationService.findOneWeight(facilityName);
        LifeEvaluation lifeEvaluations = lifeEvaluationService.findOneLife(facilityName);

        model.addAttribute("facilityEvaluationGrades", facilityEvaluationGrades);
        model.addAttribute("surveyQuestions", surveyQuestions);
        model.addAttribute("lifeEvaluations", lifeEvaluations);

        return "lifeEvaluations/lifeEvaluation";
    }

//    @GetMapping("/lifeEvaluations/findOne")
//    public String findOneWeight(Model model, String facilityName) {
////        SurveyQuestion surveyQuestions = surveyQuestionService.findOne(facilityName);
////        model.addAttribute("surveyQuestions", surveyQuestions);
//        return "lifeEvaluations/lifeEvaluation";
//    }

    @PostMapping("/lifeEvaluations")
    public String createUpdate(@RequestBody LifeEvaluation parameter){
        lifeEvaluationService.createUpdate(parameter);
        return "lifeEvaluations/lifeEvaluation";
    }
}
