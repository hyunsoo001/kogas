package com.atg.kogas.service;

import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.ReqBulk;
import com.atg.kogas.repository.FacilityBaseInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class FacilityBaseInfoService {

    private final FacilityBaseInfoRepository repository;

    public Page<FacilityBaseInfo> findAll(Pageable pageable){
        return repository.findAll(pageable);
//        return repository.findAll(Sort.by(Sort.Direction.ASC, "infoSeq"));
    }

    public Page<FacilityBaseInfo> findOne(String invenName, String locateName, String facilityName, String installName, String facilityCode, Pageable pageable){
        if( invenName.equals("") &&  locateName.equals("") &&  facilityName.equals("") &&  installName.equals("") && facilityCode.equals(""))
            return repository.findAll(pageable);
        else if(invenName != "" &&  locateName != "" &&  facilityName != "" &&  installName != "" && facilityCode != "")
            return repository.findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCode(invenName, locateName, facilityName, installName, facilityCode,pageable);
        else
            return repository.findFacilityBaseInfoByInvenNameOrLocateNameOrFacilityNameOrInstallNameOrFacilityCode(invenName, locateName, facilityName, installName, facilityCode,pageable);
    }

    public FacilityBaseInfo excelFindOne(String invenName, String locateName,String facilityName, String installName, String facilityCode, String Producer){
        return repository.findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCodeAndProducer(invenName, locateName,facilityName, installName, facilityCode, Producer);
    }


//    public List<FacilityBaseInfo> findOne2(String invenName, String locateName, String facilityName, String installName, String facilityCode){
//        return repository.findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCode(invenName,locateName, facilityName, installName, facilityCode);
//    }

    @Transactional
    public void create(FacilityBaseInfo parameter) {
        //FacilityBaseInfo res = repository.save(AppConfig.modelMapper.map(parameter, FacilityBaseInfo.class));
        repository.save(parameter);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(Long id, FacilityBaseInfo parameter){
        FacilityBaseInfo temp = repository.findFacilityBaseInfoByInfoSeq(id);
        temp.setInvenName(parameter.getInvenName());
        temp.setLocateName(parameter.getLocateName());
        temp.setInstallName(parameter.getInstallName());
        temp.setFacilityCode(parameter.getFacilityCode());
        temp.setProducer(parameter.getProducer());
        temp.setFrequency(parameter.getFrequency());
        temp.setImpellerCnt(parameter.getImpellerCnt());
        temp.setMotorSlipCnt(parameter.getMotorSlipCnt());
        temp.setBearingTimeUp(parameter.getBearingTimeUp());
        temp.setBearingTimeDown(parameter.getBearingTimeDown());

        temp.setFacilityCode(parameter.getFacilityCode());
        temp.setLocateCode(parameter.getLocateCode());
    }

    @Transactional
    public void bulkUpdate(ReqBulk<FacilityBaseInfo> parameter)  {
        List<FacilityBaseInfo> deleteList = parameter.getD();
        if (deleteList != null) {
            for (FacilityBaseInfo i : deleteList) {
                delete(i.getInfoSeq());
            }
        }
        List<FacilityBaseInfo> createList = parameter.getC();
        if (createList != null) {
            for (FacilityBaseInfo i : createList) {
                repository.save(i);
            }
        }
        List<FacilityBaseInfo> updateList = parameter.getU();
        if (updateList != null) {
            for (FacilityBaseInfo i : updateList) {
                update(i.getInfoSeq(), i);
            }
        }
    }
}
