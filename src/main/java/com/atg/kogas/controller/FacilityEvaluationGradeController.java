package com.atg.kogas.controller;

import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.ReqBulk;
import com.atg.kogas.service.FacilityBaseInfoService;
import com.atg.kogas.service.FacilityEvaluationGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FacilityEvaluationGradeController {

    private final FacilityEvaluationGradeService facilityEvaluationGradeService;

    @GetMapping("/facilityEvaluationGrades")
    public String findAll(Model model, @PageableDefault(page=0, size=10, sort="lifeCycleSeq", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<FacilityEvaluationGrade> list = facilityEvaluationGradeService.findAll(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityEvaluationGrades",list);

        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

    @GetMapping("/facilityEvaluationGrades/findOne")
    public String findOne(Model model, @RequestParam String invenName, String locateName, String facilityName, String installName, String evaluationItemName
    ,@PageableDefault(page=0, size=10, sort="lifeCycleSeq", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<FacilityEvaluationGrade> list = facilityEvaluationGradeService.findOne(invenName ,locateName,  facilityName,  installName, evaluationItemName,pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityEvaluationGrades",list);

        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

    @PostMapping("/facilityEvaluationGrades")
    public String create(@RequestBody FacilityEvaluationGrade parameter){
        facilityEvaluationGradeService.create(parameter);
        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

    @DeleteMapping("/facilityEvaluationGrades/{id}")
    public String delete(@PathVariable Long id){
        facilityEvaluationGradeService.delete(id);
        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

    @PatchMapping("/facilityEvaluationGrades/{id}")
    public String update(@PathVariable Long id, @RequestBody FacilityEvaluationGrade parameter) {
        facilityEvaluationGradeService.update(id, parameter);
        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

    @PostMapping("/facilityEvaluationGrades:bulk-update")
    public String bulkUpdate(@RequestBody ReqBulk<FacilityEvaluationGrade> parameter, Model model, @PageableDefault(page=0, size=10, sort="lifeCycleSeq", direction = Sort.Direction.ASC) Pageable pageable)  {
        facilityEvaluationGradeService.bulkUpdate(parameter);
        Page<FacilityEvaluationGrade> list = facilityEvaluationGradeService.findAll(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityEvaluationGrades",list);
        return "facilityEvaluationGrades/facilityEvaluationGradeList";
    }

}
