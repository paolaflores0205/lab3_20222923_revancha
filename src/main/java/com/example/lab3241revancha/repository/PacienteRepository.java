package com.example.lab3241revancha.repository;


import com.example.lab3241revancha.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByClinicaId(Integer clinicaId);

    List<Paciente> findPacienteByOftalmologoId(Integer oftalmologoId);

    @Query(value="SELECT * FROM paciente p WHERE p.oftalmologo_id = ?1 " +
            "AND p.fecha_cita >= CURRENT_DATE " +
            "ORDER BY p.fecha_cita ASC",
            nativeQuery = true)
    List<Paciente> findPxByProximasCitas (Integer oftId);
}
