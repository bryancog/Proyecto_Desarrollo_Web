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

import co.edu.javeriana.CaravanaMedieval.model.Ruta;
import co.edu.javeriana.CaravanaMedieval.repository.CiudadRepository;
import co.edu.javeriana.CaravanaMedieval.repository.RutaRepository;

@Controller
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping
    public String listarRutas(Model model) {
        model.addAttribute("rutas", rutaRepository.findAll());
        return "rutas/list";
    }

    @GetMapping("/nuevo")
    public String nuevaRuta(Model model) {
        model.addAttribute("ruta", new Ruta());
        model.addAttribute("ciudades", ciudadRepository.findAll());
        return "rutas/form";
    }

    @PostMapping("/guardar")
    public String guardarRuta(@ModelAttribute Ruta ruta) {
        rutaRepository.save(ruta);
        return "redirect:/rutas";
    }

    @GetMapping("/editar/{id}")
    public String editarRuta(@PathVariable Long id, Model model) {
        Optional<Ruta> ruta = rutaRepository.findById(id);
        if (ruta.isPresent()) {
            model.addAttribute("ruta", ruta.get());
            model.addAttribute("ciudades", ciudadRepository.findAll());
            return "rutas/form";
        }
        return "redirect:/rutas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRuta(@PathVariable Long id) {
        rutaRepository.deleteById(id);
        return "redirect:/rutas";
    }
}
