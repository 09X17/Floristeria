package Floristeria.controller;

import Floristeria.entity.Factura;
import Floristeria.service.FacturaService;
import Floristeria.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private PagoService pagoService;

    @GetMapping("/{idFactura}")
    public String mostrarPago(@PathVariable Long idFactura, Model model) {
        Factura factura = facturaService.findById(idFactura);
        model.addAttribute("factura", factura);
        return "pagos/pago"; 
    }

    @PostMapping("/procesar/{idFactura}")
    public String procesarPago(@PathVariable Long idFactura, @RequestParam String metodoPago) {
        pagoService.procesarPago(idFactura, metodoPago);
        return "redirect:/facturas"; 
    }

    @GetMapping("/listar")
    public String listarPagos(Model model) {
        model.addAttribute("pagos", pagoService.listarPagos());
        return "pagos/lista"; 
    }
}
