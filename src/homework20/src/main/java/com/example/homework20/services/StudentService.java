package com.example.homework20.services;

import com.example.homework20.models.Adresa;
import com.example.homework20.models.Materie;
import com.example.homework20.models.Student;
import com.example.homework20.repositories.MaterieRepository;
import com.example.homework20.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final MaterieRepository materieRepository;

    public Optional<Student> updateAdresa (Integer studentId, Adresa adresa){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            student.get().setAdresa(adresa);
            studentRepository.save(student.get());
        }
        return Optional.empty();
    }

    public String deleteStudent (Integer studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()) {
            Student stud = student.get();
            stud.getInscrieri().clear();
            studentRepository.delete(stud);
            return studentId.toString();
        } else {
            return null;
        }
    }

    public String enrollStudent(Integer studentId, Integer materieId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Materie> materie = materieRepository.findById(materieId);
        if (student.isPresent() && materie.isPresent()) {
            student.get().getCursuriAlese().add(materie.get());
            studentRepository.save(student.get());
            return "Enrolled";
        }
        return "Not present";
    }

    public List<Optional<Student>> findByNumeAndLocalitate(String nume, String localitate) {
        return studentRepository.findByNumeAndLocalitate(nume, localitate);
    }

    public Optional<Student> findByNumeAndPrenume(String nume, String prenume) {
        return studentRepository.findByNumeAndPrenume(nume, prenume);
    }

    public Optional<Student> findByNume(String nume) {
        return studentRepository.findByNume(nume);
    }
}
