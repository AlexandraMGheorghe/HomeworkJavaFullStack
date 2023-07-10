package com.example.homework24.controller;

import com.example.homework24.DTO.request.JoinCourseRequestDTO;
import com.example.homework24.DTO.response.CourseResponseDTO;
import com.example.homework24.DTO.response.JoinCourseResponseDTO;
import com.example.homework24.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/join")
    public @ResponseBody ResponseEntity<JoinCourseResponseDTO> joinCourse(@RequestBody JoinCourseRequestDTO joinCourseRequestDTO) {
        return studentService.joinCourse(joinCourseRequestDTO);
    }

    @GetMapping(path = "/courses/{studentId}")
    public @ResponseBody ResponseEntity<Set<CourseResponseDTO>> getCourses(@PathVariable Integer studentId) {
        return studentService.getCourses(studentId);
    }
}