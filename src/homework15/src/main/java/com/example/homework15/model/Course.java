package com.example.homework15.model;

import lombok.Data;

@Data
public class Course {

    private String courseName;
    private Trainer trainer;
    private boolean online;
    private CourseDays[] courseDays;
}
