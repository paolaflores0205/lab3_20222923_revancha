package com.example.lab3241revancha.repository;


import com.example.lab3241revancha.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByClinicaId(Integer clinicaId);
}
