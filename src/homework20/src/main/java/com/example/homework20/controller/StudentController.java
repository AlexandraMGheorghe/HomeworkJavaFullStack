package com.example.homework20.controller;

import com.example.homework20.models.Adresa;
import com.example.homework20.models.Student;
import com.example.homework20.repositories.StudentRepository;
import com.example.homework20.services.StudentService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/")
public class StudentController {

    @PersistenceContext
    EntityManager entityManager;
    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    @GetMapping(path = "/student/all")
    public @ResponseBody Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/student")
    public @ResponseBody Optional<Student> getStudentByNumeAndPrenume(
            @RequestParam(name = "nume") String nume,
            @RequestParam(name = "prenume", required = false) String prenume) {
        if (prenume == null) {
            return studentService.findByNume(nume);
        }

        return studentService.findByNumeAndPrenume(nume, prenume);
    }

    @GetMapping(path = "/student/localitate")
    public @ResponseBody List<Optional<Student>> getStudentByNumeAndLocalitate(
            @RequestParam(name = "nume") String nume,
            @RequestParam(name = "localitate") String localitate
    ) {
        return studentRepository.findByNumeAndLocalitate(nume, localitate);
    }

    @PostMapping("/student/enroll")
    public @ResponseBody String enrollStudent(@RequestParam(name = "studentId") Integer studentId,
                                              @RequestParam(name = "materieId") Integer materieId) {
        return studentService.enrollStudent(studentId, materieId);
    }

    @PostMapping("/student")
    public @ResponseBody Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/student/{studentId}/adresa")
    public @ResponseBody Optional<Student> updateAdresa(@PathVariable Integer studentId,
                                                        @RequestBody Adresa adresa){
        return studentService.updateAdresa(studentId,adresa);
    }

    @DeleteMapping ("/student/{studentId}")
    public @ResponseBody String deleteStudent (@PathVariable Integer studentId) {
        return studentService.deleteStudent(studentId);
    }

}
