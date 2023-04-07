package com.example.homework13.model;

import lombok.Data;

import java.util.Locale;

@Data
public class MathRequest {
    private double firstNumber;
    private double secondNumber;
    private String operation;

    public double operation(){
        double result = 0;
        switch (operation) {
            case "sum":
                result = firstNumber + secondNumber;
                break;
            case "difference":
                result = firstNumber - secondNumber;
                break;
            case "multiply":
                result = firstNumber * secondNumber;
                break;
            case "divide":
                result = firstNumber / secondNumber;
                break;
            case "power":
                result = Math.pow(firstNumber, secondNumber);
                break;
            default:
                break;
        }
        return result;
    }
}
