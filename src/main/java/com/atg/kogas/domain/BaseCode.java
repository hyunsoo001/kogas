package com.atg.kogas.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_base_code")
@Getter @Setter
public class BaseCode {

    @Id
    @Column(name = "seq")  @NotNull
    private int seqBase;

    @Column(name = "group_code") @NotNull
    private int groupCode;

    @Column(name = "base_code_name") @NotNull
    private String baseCodeName;

    @Column(name = "comm")
    private String commm;


    @Column(name = "base_code") @NotNull
    private String baseCode;

}
