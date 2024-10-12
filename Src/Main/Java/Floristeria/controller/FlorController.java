package Floristeria.controller;

import Floristeria.entity.Flor;
import Floristeria.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// controlador de flor
@Controller
@RequestMapping("/flores")
public class FlorController {

    @Autowired
    private FlorService florService;

    @GetMapping
    public String listarFlores(Model model) {
        model.addAttribute("flores", florService.findAll());
        return "flores/listar"; 
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearFlor(Model model) {
        model.addAttribute("flor", new Flor());
        return "flores/formulario"; 
    }


    @PostMapping("/guardar")
    public String guardarFlor(@ModelAttribute Flor flor) {
    florService.save(flor); 
    return "redirect:/flores"; 
}

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarFlor(@PathVariable Long id, Model model) {
        Flor flor = florService.findById(id);
        if (flor != null) {
            model.addAttribute("flor", flor);
            return "flores/formulario"; 
        } else {
            return "redirect:/flores"; 
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFlor(@PathVariable Long id) {
        florService.deleteById(id);
        return "redirect:/flores"; 
    }
}
