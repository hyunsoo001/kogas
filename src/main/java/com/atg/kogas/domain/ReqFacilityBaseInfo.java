package com.atg.kogas.domain;

import lombok.*;

import javax.persistence.Column;

@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqFacilityBaseInfo {
    private String invenName;
    private String locateName;

    private String facilityName;
    private String facilityCode;
    private String producer;

    private double frequency;
    private int impellerCnt;
    private int motorSlipCnt;
    private int bearingTimeUp;
    private int bearingTimeDown;

    private String installCode;
    private String installName;

}
