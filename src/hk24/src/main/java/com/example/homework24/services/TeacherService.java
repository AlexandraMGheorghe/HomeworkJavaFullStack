package com.example.homework24.services;

import com.example.homework24.models.Course;
import com.example.homework24.models.Teacher;
import com.example.homework24.repositories.TeacherRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository profesorRepository;

    public Optional<Teacher> findById(@NonNull Integer id) {
        return profesorRepository.findById(id);
    }

    public List<Optional<Course>> getMateriiByProfesorId(Integer id) {
        return profesorRepository.getMateriiByProfesorId(id);
    }
}
