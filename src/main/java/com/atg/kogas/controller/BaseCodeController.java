package com.atg.kogas.controller;

import org.springframework.ui.Model;
import com.atg.kogas.domain.BaseCode;
import com.atg.kogas.service.BaseCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class BaseCodeController {

    private final BaseCodeService baseCodeServiceService;

    @GetMapping("/basecodes")
    public String findAll(Model model) {
        List<BaseCode> basecodes = baseCodeServiceService.findAll();
        model.addAttribute("basecodes",basecodes);
        return "basecodes/baseCodeList";
    }


}
