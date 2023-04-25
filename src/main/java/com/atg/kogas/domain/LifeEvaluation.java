package com.atg.kogas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_evaluation_result")
@Getter @Setter
public class LifeEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_seq")
    private Long resultSeq;

    @Column(name = "result_grade")
    private String resultGrade;

    @Column(name = "result_status")
    private String resultStatus;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "lifecycle_seq")
//    private FacilityEvaluationGrade lifecycleSeq;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "weight_seq")
//    private SurveyQuestion weightSeq;
//

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "info_seq")
    private FacilityBaseInfo infoSeq;
}
