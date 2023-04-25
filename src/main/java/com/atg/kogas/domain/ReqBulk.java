package com.atg.kogas.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReqBulk<T>{

    private List<T> c;
    private List<T> u;
    private List<T> d;

}
