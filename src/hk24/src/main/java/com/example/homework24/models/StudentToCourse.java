package com.example.homework24.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_to_course")
@Data
public class StudentToCourse {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;
}