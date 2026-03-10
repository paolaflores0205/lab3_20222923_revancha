package com.example.lab3241revancha.controller;


import com.example.lab3241revancha.entity.Clinica;
import com.example.lab3241revancha.entity.Oftalmologo;
import com.example.lab3241revancha.entity.Paciente;
import com.example.lab3241revancha.repository.ClinicaRepository;
import com.example.lab3241revancha.repository.OftalmologoRepository;
import com.example.lab3241revancha.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/clinicas")
public class ClinicaController {
    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public ClinicaController(ClinicaRepository clinicaRepository,
                             OftalmologoRepository oftalmologoRepository,
                             PacienteRepository pacienteRepository) {
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/lista")
    public String listarClinicas(Model model){
        List<Clinica> listaClinicas = clinicaRepository.findAll();
        model.addAttribute("listaClinicas",listaClinicas);
        return "clinicas/lista";
    }

    @GetMapping("mostrarOftalmologos")
    public String listarOftalmologos(Model model, @RequestParam("idClinica") int idClinica){
        List<Oftalmologo> listOftByClinica = oftalmologoRepository.findByClinicaId(idClinica);
        model.addAttribute("listaOftalmologosByIdClinica",listOftByClinica);
        return "clinicas/oftalmologosByClinica";
    }

    @GetMapping("mostrarPacientes")
    public String listarPacientes(Model model, @RequestParam("idClinica") int idClinica){
        List<Paciente> listPxByPaciente = pacienteRepository.findByClinicaId(idClinica);
        model.addAttribute("listaPacientesByIdClinica",listPxByPaciente);
        return "clinicas/pacientesByClinica";
    }
}
