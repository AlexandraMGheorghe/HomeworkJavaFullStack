package com.example.homework20.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "studenti_to_materii")
@Data
public class StudentiToMaterie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_materie")
    private Materie materie;
}