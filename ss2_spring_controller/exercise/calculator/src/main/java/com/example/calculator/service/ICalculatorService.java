package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public interface ICalculatorService {
    String getResult(String action, Double operator1, Double operator2);
}
