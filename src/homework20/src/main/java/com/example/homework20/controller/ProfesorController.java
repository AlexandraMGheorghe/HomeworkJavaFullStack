package com.example.homework20.controller;

import com.example.homework20.models.Materie;
import com.example.homework20.models.Profesor;
import com.example.homework20.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class ProfesorController {
    private ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping (path = "/profesor/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesorById (@PathVariable Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(profesorService.findById(id));
    }

    @GetMapping(path = "/profesor/materii/{id}")
    public ResponseEntity<List<Optional<Materie>>> getMateriiByProfesorId(@PathVariable Integer id) {
        return ResponseEntity.ok(profesorService.getMateriiByProfesorId(id));
    }

}
