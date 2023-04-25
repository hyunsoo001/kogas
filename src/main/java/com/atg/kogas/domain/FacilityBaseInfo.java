package com.atg.kogas.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_facility_base_info")
@Getter @Setter
public class FacilityBaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_seq")
    private Long infoSeq;

    @Column(name = "inven_name")
    private String invenName;

    @Column(name = "locate_name")
    private String locateName;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "facility_code")
    private String facilityCode;

    @Column(name = "inven_code")
    private String invenCode;

    @Column(name = "locate_code")
    private String locateCode;

    @Column(name = "producer")
    private String producer;

    @Column(name = "frequency")
    private double frequency;

    @Column(name = "impeller_cnt")
    private int impellerCnt;

    @Column(name = "motor_slip_cnt")
    private int motorSlipCnt;

    @Column(name = "bearing_time_up")
    private int bearingTimeUp;

    @Column(name = "bearing_time_down")
    private int bearingTimeDown;

    @Column(name = "install_code")
    private String installCode;

    @Column(name = "install_name")
    private String installName;


}
