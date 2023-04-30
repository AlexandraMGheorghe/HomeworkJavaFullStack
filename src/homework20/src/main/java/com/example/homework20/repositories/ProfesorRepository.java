package com.example.homework20.repositories;

import com.example.homework20.models.Materie;
import com.example.homework20.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    @Query("SELECT p.materiiPredate FROM Profesor p WHERE p.id = ?1")
    List<Optional<Materie>> getMateriiByProfesorId(Integer id);
}
