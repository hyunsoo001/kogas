package com.atg.kogas.controller;

import com.atg.kogas.domain.BaseCode;
import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.ReqBulk;
import com.atg.kogas.domain.ReqFacilityBaseInfo;
import com.atg.kogas.service.BaseCodeService;
import com.atg.kogas.service.FacilityBaseInfoService;
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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FacilityBaseInfoController {

    private final FacilityBaseInfoService facilityBaseInfoService;

    @GetMapping("/facilityBaseInfos")
    public String findAll(Model model, @PageableDefault(page=0, size=10, sort="infoSeq", direction = Sort.Direction.ASC) Pageable pageable) {
        //List<FacilityBaseInfo> facilityBaseInfos = facilityBaseInfoService.findAll(pageable);

        Page<FacilityBaseInfo> list = facilityBaseInfoService.findAll(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityBaseInfos",list);
        return "facilityBaseInfos/facilityBaseInfoList";
    }

    @GetMapping("/facilityBaseInfos/findOne")
    public String findOne(Model model, @RequestParam String invenName, String locateName, String facilityName, String installName, String facilityCode
    ,@PageableDefault(page=0, size=10, sort="infoSeq", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<FacilityBaseInfo> list = facilityBaseInfoService.findOne(invenName,locateName,facilityName,installName,facilityCode, pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        List<String> temp = new ArrayList<String>();

        temp.add(invenName);
        temp.add(locateName);
        temp.add(facilityName);
        temp.add(installName);
        temp.add(facilityCode);

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityBaseInfos",list);
        model.addAttribute("temp",temp);
        return "facilityBaseInfos/facilityBaseInfoListSearch";
    }

    @PostMapping("/facilityBaseInfos")
    public String create(@RequestBody FacilityBaseInfo parameter){
        facilityBaseInfoService.create(parameter);
        return "facilityBaseInfos/facilityBaseInfoList";
    }

    @DeleteMapping("/facilityBaseInfos/{id}")
    public String delete(@PathVariable Long id){
        facilityBaseInfoService.delete(id);
        return "facilityBaseInfos/facilityBaseInfoList";
    }

    @PatchMapping("/facilityBaseInfos/{id}")
    public String update(@PathVariable Long id, @RequestBody FacilityBaseInfo parameter) {
        facilityBaseInfoService.update(id, parameter);
        return "facilityBaseInfos/facilityBaseInfoList";
    }

    @PostMapping("/facilityBaseInfos:bulk-update")
    public String bulkUpdate(@RequestBody ReqBulk<FacilityBaseInfo> parameter, Model model,  @PageableDefault(page=0, size=10, sort="infoSeq", direction = Sort.Direction.ASC) Pageable pageable)  {
        facilityBaseInfoService.bulkUpdate(parameter);
//        List<FacilityBaseInfo> facilityBaseInfos = facilityBaseInfoService.findAll();
        Page<FacilityBaseInfo> list = facilityBaseInfoService.findAll(pageable);

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage-4,1);
        int endPage = list.getTotalPages();

        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);

        model.addAttribute("facilityBaseInfos",list);
        return "facilityBaseInfos/facilityBaseInfoList";
    }

//    @GetMapping("/surveyQuestions")
//    public String page2(Model model) {
//       // List<FacilityBaseInfo> facilityBaseInfos = facilityBaseInfoService.findAll();
//       // model.addAttribute("facilityBaseInfos",facilityBaseInfos);
//        return "surveyQuestions/surveyQuestion";
//    }


}
