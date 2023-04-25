package com.atg.kogas.service;

import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.ReqBulk;
import com.atg.kogas.repository.FacilityEvaluationGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class FacilityEvaluationGradeService {

    private final FacilityEvaluationGradeRepository repository;

    public Page<FacilityEvaluationGrade> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Page<FacilityEvaluationGrade> findOne(String invenName, String locateName, String facilityName, String installName,String evaluationItemName, Pageable pageable){

        if( invenName.equals("") &&  locateName.equals("") &&  facilityName.equals("") &&  installName.equals("") && evaluationItemName.equals(""))
            return repository.findAll(pageable);
        else if(invenName != "" &&  locateName != "" &&  facilityName != "" &&  installName != "" && evaluationItemName != "")
            return repository.findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallNameAndEvaluationItemName(invenName,  locateName,  facilityName,  installName, evaluationItemName, pageable);
        else if(invenName != "" &&  locateName != "" &&  facilityName != "" &&  installName != "")
            return repository.findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallName(invenName,  locateName,  facilityName,  installName, pageable);
        else
            return repository.findFacilityEvaluationGradeByInfoSeqInvenNameOrInfoSeqLocateNameOrInfoSeqFacilityNameOrInfoSeqInstallNameOrEvaluationItemName( invenName,  locateName,  facilityName,  installName, evaluationItemName, pageable);


//        return repository.findAll(Sort.by(Sort.Direction.ASC, "lifeCycleSeq"));
//        return repository.findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallNameAndEvaluationItemName(invenName,  locateName,  facilityName,  installName, evaluationItemName);
//
//
//        return repository.findFacilityEvaluationGradeByInfoSeqInvenNameOrInfoSeqLocateNameOrInfoSeqFacilityNameOrInfoSeqInstallNameOrEvaluationItemName( invenName,  locateName,  facilityName,  installName, evaluationItemName);
}

//    public List<FacilityEvaluationGrade> findOne2(String invenName, String locateName, String facilityName, String installName, String facilityCode){
//        return repository.findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCode(invenName,locateName, facilityName, installName, facilityCode);
//    }

    @Transactional
    public void create(FacilityEvaluationGrade parameter) {
        //FacilityBaseInfo res = repository.save(AppConfig.modelMapper.map(parameter, FacilityBaseInfo.class));
        repository.save(parameter);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(Long id, FacilityEvaluationGrade parameter){
//        FacilityBaseInfo temp = repository.findFacilityBaseInfoByInfoSeq(id);
//        temp.setInvenName(parameter.getInvenName());
//        temp.setLocateName(parameter.getLocateName());
//        temp.setInstallName(parameter.getInstallName());
//        temp.setFacilityCode(parameter.getFacilityCode());
//        temp.setProducer(parameter.getProducer());
//        temp.setFrequency(parameter.getFrequency());
//        temp.setImpellerCnt(parameter.getImpellerCnt());
//        temp.setMotorSlipCnt(parameter.getMotorSlipCnt());
//        temp.setBearingTimeUp(parameter.getBearingTimeUp());
//        temp.setBearingTimeDown(parameter.getBearingTimeDown());
//
//        temp.setFacilityCode(parameter.getFacilityCode());
//        temp.setLocateCode(parameter.getLocateCode());
    }

    @Transactional
    public void bulkUpdate(ReqBulk<FacilityEvaluationGrade> parameter)  {
        List<FacilityEvaluationGrade> deleteList = parameter.getD();
        if (deleteList != null) {
            for (FacilityEvaluationGrade i : deleteList) {
                delete(i.getLifeCycleSeq());
            }
        }
        List<FacilityEvaluationGrade> createList = parameter.getC();
        if (createList != null) {
            for (FacilityEvaluationGrade i : createList) {
                repository.save(i);
            }
        }
        List<FacilityEvaluationGrade> updateList = parameter.getU();
        if (updateList != null) {
            for (FacilityEvaluationGrade i : updateList) {
                update(i.getLifeCycleSeq(), i);
            }
        }
    }
}
