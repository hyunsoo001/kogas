package com.atg.kogas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_evaluation_item")
@Getter @Setter
public class EvaluationItem {
    @Id
    @Column(name = "survey_seq")  @NotNull
    private Long survey_seq;

    private Long itemSeq;
    String evaluationItemCode;
    String unit;
    double evaluationValue;



}
