package com.example.homework24.DTO.response;


import com.example.homework24.models.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TeacherSuccessResponseDTO {
    private long id;
    private String name;
    private Set<Course> courses;
}
