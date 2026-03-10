package com.example.lab3241revancha.repository;


import com.example.lab3241revancha.entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {

}
