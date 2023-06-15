package com.example.ss1_introduction_to_spring_mvc.service;

import org.springframework.stereotype.Service;

@Service
public interface IConvertMoneyService {
    Double changeMoney(double money, double rate);
}
