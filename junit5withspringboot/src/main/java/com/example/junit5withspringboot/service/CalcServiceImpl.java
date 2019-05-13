package com.example.junit5withspringboot.service;


import com.example.junit5withspringboot.configure.bean.Calculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalcServiceImpl implements CalcService {

    private final Calculator calculator;

    @Override
    public int add(int a, int b) {
        return calculator.add(a, b);
    }
}
