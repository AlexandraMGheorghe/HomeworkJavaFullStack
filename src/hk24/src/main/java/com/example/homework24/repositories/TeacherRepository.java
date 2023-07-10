package com.example.homework24.repositories;

import com.example.homework24.models.Course;
import com.example.homework24.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT p.materiiPredate FROM Profesor p WHERE p.id = ?1")
    List<Optional<Course>> getMateriiByProfesorId(Integer id);
}
