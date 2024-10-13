package Floristeria.controller;

import Floristeria.entity.Entrega;
import Floristeria.entity.EstadoEntrega;
import Floristeria.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.persistence.EntityNotFoundException; 
import java.util.List;

@Controller
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public String listarEntregas(Model model) {
        List<Entrega> entregas = entregaService.obtenerEntregas();
        model.addAttribute("entregas", entregas);
        return "entregas/entregas";
    }

    @PostMapping("/asignar")
    public String asignarEntrega(@ModelAttribute Entrega entrega) {
        if (entrega == null || entrega.getId() == null) {
            
            return "redirect:/entregas?error=Entrega no válida";
        }
        entregaService.crearEntrega(entrega);
        return "redirect:/entregas";
    }

    @PutMapping("/actualizar-estado/{id}")
    public String actualizarEstado(@PathVariable Long id, @RequestParam EstadoEntrega estado) {
        try {
            entregaService.actualizarEstadoEntrega(id, estado);
        } catch (Exception e) {
            return "redirect:/entregas?error=Error al actualizar estado";
        }
        return "redirect:/entregas";
    }

    @GetMapping("/notificar-cliente/{id}")
    public String notificarCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            entregaService.notificarClienteSobreEntrega(id);
            redirectAttributes.addFlashAttribute("successMessage", "Notificación enviada con éxito.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Entrega no encontrada.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al notificar cliente.");
        }
        return "redirect:/entregas";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaEntrega(Model model) {
        model.addAttribute("entrega", new Entrega());
        return "entregas/nuevaEntrega";
    }
}