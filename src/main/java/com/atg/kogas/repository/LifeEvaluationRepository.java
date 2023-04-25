package com.atg.kogas.repository;

import com.atg.kogas.domain.FacilityBaseInfo;
import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.LifeEvaluation;
import com.atg.kogas.domain.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LifeEvaluationRepository extends JpaRepository<LifeEvaluation, Long> {

    //LifeEvaluation findLifeEvaluationByInfoSeq(Long infoSeq);
    LifeEvaluation findLifeEvaluationByInfoSeq_InfoSeq(Long infoSeq);

    LifeEvaluation findLifeEvaluationByInfoSeq_FacilityName(String facilityName);
}
