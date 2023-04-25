package com.atg.kogas.controller;

import com.atg.kogas.domain.ExcelData;
import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.service.FacilityBaseInfoService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExcelDataController {

    private final FacilityBaseInfoService facilityBaseInfoService;

    @SneakyThrows
    @PostMapping("/excel/read")
    public String readExcel(@RequestParam("file1") MultipartFile file, Model model) {//throws TikaException, IOException { // 2

        List<ExcelData> dataList = new ArrayList<>();

        List<FacilityBaseInfo> dataList1 = new ArrayList<>();


//        try (InputStream is = file.getInputStream();) {
        InputStream is = file.getInputStream();
        //Tika tika = new Tika();
        //String mimeType = tika.detect(is);

        //if (isAllowedMIMEType(mimeType)) {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());

        Sheet worksheet = workbook.getSheetAt(0);

        String atchFileId = null;

        int a =1;

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) { // 1번째 행부터 끝까지
            Row row = worksheet.getRow(i);

            ExcelData data = new ExcelData();

            FacilityBaseInfo data1 = new FacilityBaseInfo();

           // data1.setInfoSeq((long) row.getCell(0).getNumericCellValue());

            data1.setInvenName(row.getCell(0).getStringCellValue());
            data1.setLocateName(row.getCell(1).getStringCellValue());
            data1.setFacilityName(row.getCell(2).getStringCellValue());
            data1.setFacilityCode(row.getCell(3).getStringCellValue());
            data1.setProducer(row.getCell(4).getStringCellValue());
            data1.setInstallName(row.getCell(5).getStringCellValue());
            //data1.setInstallCode(row.getCell(4).getStringCellValue());4


            data1.setFrequency(row.getCell(6).getNumericCellValue());
            data1.setImpellerCnt((int) row.getCell(7).getNumericCellValue());
            data1.setMotorSlipCnt((int)row.getCell(8).getNumericCellValue());
            data1.setBearingTimeUp((int)row.getCell(9).getNumericCellValue());
            data1.setBearingTimeDown((int) row.getCell(10).getNumericCellValue());

            if(row.getCell(4).getStringCellValue().equals("공통")) data1.setInstallCode("st01");
            else if(row.getCell(4).getStringCellValue().equals("외부식")) data1.setInstallCode("st02");
            else if(row.getCell(4).getStringCellValue().equals("잠액식")) data1.setInstallCode("st03");
            else if(row.getCell(4).getStringCellValue().equals("외부모터식")) data1.setInstallCode("st02");

            //if(row.getCell(0).getStringCellValue().equals("생산운영처")) data1.setInvenCode("in01");

            FacilityBaseInfo tempFind = facilityBaseInfoService.excelFindOne(data1.getInvenName(),data1.getLocateName(),data1.getFacilityName(),data1.getInstallName(),data1.getFacilityCode(),data1.getProducer());

            if(tempFind ==null)
                facilityBaseInfoService.create(data1);



            //dataList1.add(data1);



//            data.setNum((int) row.getCell(0).getNumericCellValue());
//            data.setName(row.getCell(1).getStringCellValue());//getStringCellValue());
//            dataList.add(data);
        }

       // model.addAttribute("dataList", dataList);


//            } else {
//                throw new IOException();
//            }
//        } catch (Exception e) {
//            throw new TikaException("ERROR");
//        }

        return "facilityBaseInfos/facilityBaseInfoList";
    }
}

//
//    private boolean isAllowedMIMEType(String mimeType) {
//        if (mimeType.equals("application/x-tika-ooxml"))
//            return true;
//        return false;
//    }
//}