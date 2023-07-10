package com.example.homework24.controller;

import com.example.homework24.DTO.request.LoginRequestDTO;
import com.example.homework24.DTO.request.RegisterRequestDTO;
import com.example.homework24.DTO.response.CourseResponseDTO;
import com.example.homework24.models.Course;
import com.example.homework24.services.StudentService;
import com.example.homework24.services.TeacherService;
import com.example.homework24.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        return userService.register(registerRequestDTO);
    }

    @PostMapping("/home/{courses}")
    @PreAuthorize("hasAnyAuthority('User')")
    public ResponseEntity<Set<CourseResponseDTO>> getcourses(@PathVariable(name = "userId") Integer userId)
                                    {
        return studentService.getCourses(userId);
    }

    @PostMapping("/home/{theachers}")
    @PreAuthorize("hasAnyAuthority('Admin', 'Staff')")
    public List<Optional<Course>> getTeacher( @PathVariable(name = "userId") Integer userId)
    {
        return teacherService.getMateriiByProfesorId(userId);
    }
}