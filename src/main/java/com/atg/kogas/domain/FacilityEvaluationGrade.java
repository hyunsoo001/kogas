package com.atg.kogas.domain;


import com.atg.kogas.domain.FacilityBaseInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_facility_evaluation_grade")
@Getter @Setter
public class FacilityEvaluationGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lifecycle_seq")
    private Long lifeCycleSeq;

    @Column(name = "evaluation_item_code")
    private String evaluationItemCode;

    @Column(name = "evaluation_item_name")
    private String evaluationItemName;

    @Column(name = "unit")
    private String unit;

    @Column(name = "g_poor")
    private String gradePoor;

    @Column(name = "g_bad")
    private String gradeBad;

    @Column(name = "g_general")
    private String gradeGeneral;

    @Column(name = "g_good")
    private String gradeGood;

    @Column(name = "g_excel")
    private String gradeExcel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_seq")
    private FacilityBaseInfo infoSeq;
}