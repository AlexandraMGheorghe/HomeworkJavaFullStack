package com.example.homework24.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinCourseResponseDTO {

    private Integer id;
    private Integer studentId;
    private Integer courseId;
}