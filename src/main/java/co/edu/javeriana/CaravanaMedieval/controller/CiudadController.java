package co.edu.javeriana.CaravanaMedieval.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.javeriana.CaravanaMedieval.model.Ciudad;
import co.edu.javeriana.CaravanaMedieval.repository.CiudadRepository;

@Controller
@RequestMapping("/ciudades")
public class CiudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public String listarCiudades(Model model) {
        model.addAttribute("ciudades", ciudadRepository.findAll());
        return "ciudades/list";
    }

    @GetMapping("/nuevo")
    public String nuevaCiudad(Model model) {
        model.addAttribute("ciudad", new Ciudad());
        return "ciudades/form";
    }

    @PostMapping("/guardar")
    public String guardarCiudad(@ModelAttribute Ciudad ciudad) {
        ciudadRepository.save(ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editarCiudad(@PathVariable Long id, Model model) {
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if (ciudad.isPresent()) {
            model.addAttribute("ciudad", ciudad.get());
            return "ciudades/form";
        }
        return "redirect:/ciudades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCiudad(@PathVariable Long id) {
        ciudadRepository.deleteById(id);
        return "redirect:/ciudades";
    }
}

