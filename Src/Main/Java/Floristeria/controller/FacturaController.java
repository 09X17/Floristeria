package Floristeria.controller;

import Floristeria.entity.Factura;
import Floristeria.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/{idPedido}")
    public String mostrarFactura(@PathVariable Long idPedido, Model model) {
        Factura factura = facturaService.generarFactura(idPedido);
        model.addAttribute("factura", factura);
        return "facturas/detalle"; 
    }

    @PostMapping("/registrar-pago/{idFactura}")
    public String registrarPago(@PathVariable Long idFactura, @RequestParam String metodoPago) {
        facturaService.registrarPago(idFactura, metodoPago);
        return "redirect:/facturas"; 
    }
}
