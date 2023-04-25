package com.atg.kogas.repository;

import com.atg.kogas.domain.FacilityEvaluationGrade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityEvaluationGradeRepository extends JpaRepository<FacilityEvaluationGrade, Long> {
    List<FacilityEvaluationGrade> findFacilityEvaluationGradeByEvaluationItemName(String evaluationItemName);

    List<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenName(String invenName);

    //5개 고른경우
    Page<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallNameAndEvaluationItemName(String invenName, String locateName, String facilityName, String installName,  String evaluationItemName, Pageable pageable);

    //1개 고른경우
    Page<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameOrInfoSeqLocateNameOrInfoSeqFacilityNameOrInfoSeqInstallNameOrEvaluationItemName(String invenName, String locateName, String facilityName, String installName,  String evaluationItemName, Pageable pageable);

    //앞에 4개 고른 경우
    Page<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallName(String invenName, String locateName, String facilityName, String installName, Pageable pageable);


    //List<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeq_LocateNameAndInfoSeq_FacilityName(String invenName, String locateName, String facilityName);
    List<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityName(String invenName, String locateName, String facilityName);

    List<FacilityEvaluationGrade> findFacilityEvaluationGradeByInfoSeqInvenNameAndInfoSeqLocateNameAndInfoSeqFacilityNameAndInfoSeqInstallCode(String invenName, String locateName, String facilityName, String installCode);
}
