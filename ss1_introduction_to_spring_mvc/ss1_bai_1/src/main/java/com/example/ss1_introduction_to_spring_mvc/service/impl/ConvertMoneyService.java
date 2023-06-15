package com.example.ss1_introduction_to_spring_mvc.service.impl;

import com.example.ss1_introduction_to_spring_mvc.service.IConvertMoneyService;
import org.springframework.stereotype.Service;

@Service
public class ConvertMoneyService implements IConvertMoneyService {
    @Override
    public Double changeMoney(double money, double rate) {
        if (money < 0 || rate < 0) {
            return -1.0;
        } else {
            return money * rate;
        }
    }
}
