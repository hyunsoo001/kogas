package com.atg.kogas.service;

import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.LifeEvaluation;
import com.atg.kogas.domain.SurveyQuestion;
import com.atg.kogas.repository.FacilityBaseInfoRepository;
import com.atg.kogas.repository.FacilityEvaluationGradeRepository;
import com.atg.kogas.repository.LifeEvaluationRepository;
import com.atg.kogas.repository.SurveyQuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class LifeEvaluationService {

    private final LifeEvaluationRepository repository;

    private final SurveyQuestionRepository repository2;

    private final FacilityEvaluationGradeRepository repository3;

    public List<LifeEvaluation> findAll() {

        return repository.findAll(Sort.by(Sort.Direction.ASC, "resultSeq"));
    }

    public List<FacilityEvaluationGrade> findOneGrade(String inveName, String locateName, String facilityName, String installCode) {
        //FacilityBaseInfo B = repository.findLifeEvaluationByLifecycleSeqInfoSeq_InvenNameAndLifecycleSeqInfoSeq_LocateNameAndLifecycleSeq_InfoSeq_FacilityName(inveName, locateName, facilityName);
        //return repository.findLifeEvaluationByLifecycleSeq(B.getInfoSeq());
        //return repository3.findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityName (inveName,locateName,facilityName);
        return repository3.findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallCode(inveName,locateName,facilityName,installCode);
    }

    public List<SurveyQuestion> findOneWeight(String facilityName) {
        return repository2.findByFacilityName(facilityName);
    }

    public LifeEvaluation findOneLife(String facilityName) {
        return repository.findLifeEvaluationByInfoSeq_FacilityName(facilityName);
    }


    public LifeEvaluation create(LifeEvaluation parameter){
        return repository.save(parameter);
    }

    @Transactional
    public void createUpdate(LifeEvaluation parameter){
        LifeEvaluation temp = repository.findLifeEvaluationByInfoSeq_InfoSeq(parameter.getInfoSeq().getInfoSeq());
        LifeEvaluation temp2 = repository.findById(temp.getResultSeq()).get();

        log.info(String.valueOf(temp.getResultSeq()));
        log.info(String.valueOf(parameter.getResultGrade()));
//
//        temp2.setResultGrade(parameter.getResultGrade());
//        temp2.setResultStatus(parameter.getResultStatus());

        if(temp == null ){
            repository.save(parameter);
        }
        else{
            temp2.setResultGrade(parameter.getResultGrade());
            temp2.setResultStatus(parameter.getResultStatus());
        }

    }
}
