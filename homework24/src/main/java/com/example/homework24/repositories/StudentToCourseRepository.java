package com.example.homework24.repositories;

import com.example.homework24.models.StudentToCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentToCourseRepository extends JpaRepository<StudentToCourse, Integer> {
}
