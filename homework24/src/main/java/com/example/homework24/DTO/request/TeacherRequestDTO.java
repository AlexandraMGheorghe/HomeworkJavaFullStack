package com.example.homework24.DTO.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TeacherRequestDTO {

    @NotEmpty(message = "teacherName.must.not.be.null.or.empty")
    private String teacherName;
    @NotEmpty(message = "courseName.must.not.be.null.or.empty")
    private String courseName;
}
