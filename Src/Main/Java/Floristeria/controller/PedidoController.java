package Floristeria.controller;

import Floristeria.entity.Pedido;
import Floristeria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//pedidos
@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedidos/listar";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrearPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedidos/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
    if (pedido.getEstado() == null) {
        pedido.setEstado("En curso"); 
    }
    pedidoService.save(pedido);
    return "redirect:/pedidos";
}


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoService.findById(id);
        if (pedido != null) {
            model.addAttribute("pedido", pedido);
            return "pedidos/formulario";
        } else {
            return "redirect:/pedidos";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return "redirect:/pedidos";
    }
}
