package com.atg.kogas.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_weighting_survey")
@Getter @Setter
public class SurveyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weight_seq")
    private Long weightSeq;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "p1")
    private Long p1;

    @Column(name = "p2")
    private Long p2;

    @Column(name = "p3")
    private Long p3;

    @Column(name = "p4")
    private Long p4;

    @Column(name = "p5")
    private Long p5;

    @Column(name = "p6")
    private Long p6;

    @Column(name = "p7")
    private Long p7;

    @Column(name = "p8")
    private Long p8;

    @Column(name = "p9")
    private Long p9;

    @Column(name = "p10")
    private Long p10;

    @Column(name = "p11")
    private Long p11;

    @Column(name = "p12")
    private Long p12;

    @Column(name = "p13")
    private Long p13;

    @Column(name = "p14")
    private Long p14;

    @Column(name = "p15")
    private Long p15;

    @Column(name = "p16")
    private Long p16;

    @Column(name = "p17")
    private Long p17;

    @Column(name = "p18")
    private Long p18;


    @Column(name = "w1")
    private float w1;

    @Column(name = "w2")
    private float w2;

    @Column(name = "w3")
    private float w3;

    @Column(name = "w4")
    private float w4;

    @Column(name = "w5")
    private float w5;

    @Column(name = "w6")
    private float w6;

    @Column(name = "w7")
    private float w7;

    @Column(name = "w8")
    private float w8;

    @Column(name = "w9")
    private float w9;

    @Column(name = "w10")
    private float w10;

    @Column(name = "w11")
    private float w11;

    @Column(name = "w12")
    private float w12;

    @Column(name = "w13")
    private float w13;

    @Column(name = "w14")
    private float w14;

    @Column(name = "w15")
    private float w15;

    @Column(name = "w16")
    private float w16;

    @Column(name = "w17")
    private float w17;





}
