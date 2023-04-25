package com.atg.kogas.service;

import com.atg.kogas.domain.BaseCode;
import com.atg.kogas.repository.BaseCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BaseCodeService {

    private final BaseCodeRepository repository;

    public List<BaseCode> findAll(){
        return repository.findAll();
    }
}
