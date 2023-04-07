package com.example.homework13.model;

import lombok.Data;

public class MathResult {

    private double result;

    public MathResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}


