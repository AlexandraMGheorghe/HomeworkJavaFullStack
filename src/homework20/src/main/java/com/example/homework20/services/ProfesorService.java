package com.example.homework20.services;

import com.example.homework20.models.Materie;
import com.example.homework20.models.Profesor;
import com.example.homework20.repositories.ProfesorRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository profesorRepository;

    public Optional<Profesor> findById(@NonNull Integer id){
        return profesorRepository.findById(id);
    }

    public List<Optional<Materie>> getMateriiByProfesorId(Integer id) {
        return profesorRepository.getMateriiByProfesorId(id);
    }
}
