package com.atg.kogas.repository;

import com.atg.kogas.domain.FacilityEvaluationGrade;
import com.atg.kogas.domain.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {

    SurveyQuestion findAllByFacilityName(String facilityName);

    List<SurveyQuestion> findByFacilityName(String facilityName);

}
