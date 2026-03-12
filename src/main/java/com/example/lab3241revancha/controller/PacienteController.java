package com.example.lab3241revancha.controller;

import com.example.lab3241revancha.entity.Oftalmologo;
import com.example.lab3241revancha.entity.Paciente;
import com.example.lab3241revancha.repository.ClinicaRepository;
import com.example.lab3241revancha.repository.OftalmologoRepository;
import com.example.lab3241revancha.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    final ClinicaRepository clinicaRepository;
    final OftalmologoRepository oftalmologoRepository;
    final PacienteRepository pacienteRepository;

    public PacienteController(ClinicaRepository clinicaRepository,
                                 OftalmologoRepository oftalmologoRepository,
                                 PacienteRepository pacienteRepository) {
        this.clinicaRepository = clinicaRepository;
        this.oftalmologoRepository = oftalmologoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/lista")
    public String listarPacientes(Model model){
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        model.addAttribute("listaPacientes",listaPacientes);
        return "pacientes/lista";
    }

    @GetMapping("/editar")
    public String editarPx(Model model, @RequestParam("idPx") int id){

        Optional<Paciente> optPx = pacienteRepository.findById(id);

        if(optPx.isPresent()){
            Paciente px = optPx.get();
            model.addAttribute("paciente", px);
            return "pacientes/editFrm";
        } else {
            return "redirect:/pacientes/listar";
        }

    }

    @PostMapping("/guardar")
    public String guardarPx(@RequestParam("id") Integer idpx,
                            @RequestParam("numero_habitacion") Integer nro){

        pacienteRepository.editarPx(idpx, nro);
        return "redirect:/pacientes/listar";
    }


    @GetMapping("/formularioPaciente")
    public String derivarPx(Model model, @RequestParam("idPx") int idpx){
        Optional<Paciente> optPx = pacienteRepository.findById(idpx);
        if(optPx.isPresent()){
            Paciente px = optPx.get();
            model.addAttribute("paciente", px);
            List<Oftalmologo> lista = oftalmologoRepository.findAll();
            model.addAttribute("listaOft",lista);
            return  "pacientes/derivarFrm";
        }else {
            return "redirect:/pacientes/listar";
        }
    }










}
