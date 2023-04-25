package com.atg.kogas.service;

import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.SurveyQuestion;
import com.atg.kogas.repository.FacilityEvaluationGradeRepository;
import com.atg.kogas.repository.SurveyQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyQuestionService {

    private final SurveyQuestionRepository repository;

    public List<SurveyQuestion> findAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "weightSeq"));
    }

    public SurveyQuestion findOne(String facilityName){
            return repository.findAllByFacilityName(facilityName);
    }

   // @Transactional
    public void create(SurveyQuestion parameter) {
        SurveyQuestion temp = repository.findById(parameter.getWeightSeq()).get();
        repository.save(temp);
    }

    @Transactional
    public void update(SurveyQuestion parameter){
        SurveyQuestion temp = repository.findById(parameter.getWeightSeq()).get();
        temp.setFacilityName(parameter.getFacilityName());
        temp.setWeightSeq(parameter.getWeightSeq());

        temp.setP1(parameter.getP1());
        temp.setP2(parameter.getP2());
        temp.setP3(parameter.getP3());
        temp.setP4(parameter.getP4());
        temp.setP5(parameter.getP5());
        temp.setP6(parameter.getP6());
        temp.setP7(parameter.getP7());
        temp.setP8(parameter.getP8());
        temp.setP9(parameter.getP9());
        temp.setP10(parameter.getP10());
        temp.setP11(parameter.getP11());
        temp.setP12(parameter.getP12());
        temp.setP13(parameter.getP13());
        temp.setP14(parameter.getP14());
        temp.setP15(parameter.getP15());
        temp.setP16(parameter.getP16());
        temp.setP17(parameter.getP17());
        temp.setP18(parameter.getP18());

        temp.setW1(parameter.getW1());
        temp.setW2(parameter.getW2());
        temp.setW3(parameter.getW3());
        temp.setW4(parameter.getW4());
        temp.setW5(parameter.getW5());
        temp.setW6(parameter.getW6());
        temp.setW7(parameter.getW7());
        temp.setW8(parameter.getW8());
        temp.setW9(parameter.getW9());
        temp.setW10(parameter.getW10());
        temp.setW11(parameter.getW11());
        temp.setW12(parameter.getW12());
        temp.setW13(parameter.getW13());
        temp.setW14(parameter.getW14());
        temp.setW15(parameter.getW15());
        temp.setW16(parameter.getW16());
        temp.setW17(parameter.getW17());


    }
}
