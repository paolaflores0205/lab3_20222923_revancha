package com.example.lab3241revancha.repository;


import com.example.lab3241revancha.entity.Oftalmologo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OftalmologoRepository extends JpaRepository<Oftalmologo, Integer> {
    //List<Oftalmologo> findByClinicaId (Integer clinicaId);
    List<Oftalmologo> findByClinicaId(Integer clinicaId);




}
