package com.example.lab3241revancha.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "genero", nullable = false, length = 45)
    private String genero;

    @Column(name = "diagnostico", nullable = false, length = 100)
    private String diagnostico;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha_cita;

    @Column(name = "numero_habitacion", nullable = false)
    private Integer numero_habitacion;

    @ManyToOne
    @JoinColumn(name = "oftalmologo_id", nullable = false)
    private Oftalmologo oftalmologo;

    @ManyToOne
    @JoinColumn(name = "clinica_id", nullable = false)
    private Clinica clinica;


}
