package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public String getResult(String action, Double operator1, Double operator2) {
        String result = "";
        switch (action) {
            case "addition":
                result = String.valueOf(operator1 + operator2);
                break;
            case "subtraction":
                result = String.valueOf(operator1 - operator2);
                break;
            case "multiplication":
                result = String.valueOf(operator1 * operator2);
                break;
            case "division":
                if (operator2 == 0) {
                    result = "ERROR! error divisible by 0!";
                } else {
                    result = String.valueOf(operator1 / operator2);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
        return result;
    }
}
