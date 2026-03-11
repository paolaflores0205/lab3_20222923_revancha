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
@RequestMapping("/oftalmologos")
public class OftalmologoController {

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public OftalmologoController(ClinicaRepository clinicaRepository,
                             OftalmologoRepository oftalmologoRepository,
                             PacienteRepository pacienteRepository) {
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/lista")
    public String listarOftalmologos(Model model){
        List<Oftalmologo> listaOftalmologos = oftalmologoRepository.findAll();
        model.addAttribute("listaOftalmologos",listaOftalmologos);
        return "oftalmologos/lista";
    }

    @GetMapping("/mostrarPacientes")
    public String listarPacientes(Model model, @RequestParam("idOft") int idOft){
        List<Paciente> listPxByOft = pacienteRepository.findPacienteByOftalmologoId(idOft);
        model.addAttribute("listaPacientesByIdOft",listPxByOft);
        return "oftalmologos/pacientesByOft";
    }

    @GetMapping("/proximasCitas")
    public String listarProximasCitas(Model model, @RequestParam("idOft") int idOft){
        List<Paciente> listProximasCitas = pacienteRepository.findPxByProximasCitas(idOft);
        model.addAttribute("listaProximasCitas",listProximasCitas);
        return "oftalmologos/pacientesByProximasCitas";
    }




}
