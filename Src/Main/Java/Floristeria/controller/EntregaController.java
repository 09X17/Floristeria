package Floristeria.controller;

import Floristeria.entity.Entrega;
import Floristeria.entity.EstadoEntrega;
import Floristeria.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.persistence.EntityNotFoundException; // Asegúrate de agregar esta importación
import java.util.List;

@Controller
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public String listarEntregas(Model model) {
        List<Entrega> entregas = entregaService.listarEntregas(); // Ahora debería funcionar
        model.addAttribute("entregas", entregas);
        return "entregas/entregas"; // Ruta a tu archivo HTML
    }

    @PostMapping("/asignar")
    public String asignarEntrega(@ModelAttribute Entrega entrega) {
        entregaService.asignarEntrega(entrega);
        return "redirect:/entregas"; // Redirigir después de asignar
    }

    @PutMapping("/actualizar-estado/{id}")
    public String actualizarEstado(@PathVariable Long id, @RequestParam EstadoEntrega estado) {
        entregaService.actualizarEstado(id, estado);
        return "redirect:/entregas"; // Redirigir después de actualizar
    }

    @GetMapping("/notificar-cliente/{id}")
    public String notificarCliente(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            entregaService.notificarCliente(id);
            redirectAttributes.addFlashAttribute("successMessage", "Notificación enviada con éxito.");
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Entrega no encontrada.");
        }
        return "redirect:/entregas"; // Redirigir después de notificar
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNuevaEntrega(Model model) {
        model.addAttribute("entrega", new Entrega()); // Asegúrate de que la clase Entrega tenga un constructor sin argumentos
        return "entregas/nuevaEntrega"; // Ruta a tu archivo HTML para crear una nueva entrega
    }
}
