package com.example.homework24.controller;

import com.example.homework24.DTO.request.TeacherRequestDTO;
import com.example.homework24.DTO.response.TeacherSuccessResponseDTO;
import com.example.homework24.models.Course;
import com.example.homework24.models.Teacher;
import com.example.homework24.repositories.CourseRepository;
import com.example.homework24.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    @Autowired
    public TeacherController(TeacherRepository profesorRepository, CourseRepository materieRepository) {
        this.teacherRepository = profesorRepository;
        this.courseRepository = materieRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    ResponseEntity<List<TeacherSuccessResponseDTO>> getTeachers() {
        Iterable<Teacher> teachers = teacherRepository.findAll();

        List<TeacherSuccessResponseDTO> response = new ArrayList<>();
        for(Teacher teacher: teachers) {
            response.add(new TeacherSuccessResponseDTO(teacher.getId(), teacher.getName(), teacher.getCourseSet()));
        }

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/add")
    public @Transactional
    @ResponseBody
    ResponseEntity<TeacherSuccessResponseDTO> addTeacher(@RequestBody TeacherRequestDTO teacherRequest) {

        Teacher teacher = new Teacher();
        teacher.setName(teacherRequest.getTeacherName());
        teacher = teacherRepository.save(teacher);

        Course course = new Course();
        course.setName(teacherRequest.getCourseName());
        course.setTeacher(teacher);
        courseRepository.save(course);

        return new ResponseEntity<>(new TeacherSuccessResponseDTO(teacher.getId(), teacher.getName(), Set.of(course)), HttpStatus.CREATED);
    }
}