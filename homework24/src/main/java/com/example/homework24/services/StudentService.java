package com.example.homework24.services;

import com.example.homework24.DTO.request.JoinCourseRequestDTO;
import com.example.homework24.DTO.response.CourseResponseDTO;
import com.example.homework24.DTO.response.JoinCourseResponseDTO;
import com.example.homework24.models.Course;
import com.example.homework24.models.Student;
import com.example.homework24.models.StudentToCourse;
import com.example.homework24.repositories.CourseRepository;
import com.example.homework24.repositories.StudentRepository;
import com.example.homework24.repositories.StudentToCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentToCourseRepository studentToCourseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, StudentToCourseRepository studentToCourseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentToCourseRepository = studentToCourseRepository;
    }

    public ResponseEntity<JoinCourseResponseDTO> joinCourse(JoinCourseRequestDTO joinCourseRequestDTO) {
        Student student = studentRepository.getById(joinCourseRequestDTO.getStudentId());
        Course course = courseRepository.getById(joinCourseRequestDTO.getCourseId());
        StudentToCourse studentToCourse = new StudentToCourse();
        studentToCourse.setStudent(student);
        studentToCourse.setCourse(course);
        studentToCourseRepository.save(studentToCourse);

        return new ResponseEntity<>(new JoinCourseResponseDTO(studentToCourse.getId(), studentToCourse.getStudent().getId(), studentToCourse.getCourse().getId()), HttpStatus.CREATED);
    }

    public ResponseEntity<Set<CourseResponseDTO>> getCourses(Integer studentId) {
        Student student = studentRepository.getById(studentId);
        Set<Course> courseSet = student.getChosenCourses();
        Set<CourseResponseDTO> courseResponseDTOset = new HashSet<>();
        for (Course course : courseSet) {
            courseResponseDTOset.add(new CourseResponseDTO(course.getId(), course.getName(), course.getTeacher().getId()));
        }

        return new ResponseEntity<>(courseResponseDTOset, HttpStatus.ACCEPTED);
    }
}