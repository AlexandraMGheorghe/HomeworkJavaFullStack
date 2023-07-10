package com.example.homework24.controller;

import com.example.homework24.DTO.request.CourseRequestDTO;
import com.example.homework24.DTO.response.CourseResponseDTO;
import com.example.homework24.models.Course;
import com.example.homework24.models.Teacher;
import com.example.homework24.repositories.CourseRepository;
import com.example.homework24.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<List<Course>> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/add/{teacherId}")
    public @ResponseBody ResponseEntity<CourseResponseDTO> addCourse(@PathVariable Integer teacherId, @RequestBody CourseRequestDTO courseRequestDTO) {

        Teacher teacher = teacherRepository.getById(teacherId);
        Course course = new Course();
        course.setName(courseRequestDTO.getName());
        course.setTeacher(teacher);

        Course savedCourse = courseRepository.save(course);
        return new ResponseEntity<>(new CourseResponseDTO(savedCourse.getId(), savedCourse.getName(), savedCourse.getTeacher().getId()), HttpStatus.CREATED);
    }
}