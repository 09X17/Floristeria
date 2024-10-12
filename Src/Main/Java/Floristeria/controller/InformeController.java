package Floristeria.controller;

import Floristeria.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//informes
import java.util.List;

@Controller
public class InformeController {

    @Autowired
    private InformeService informeService;

    @GetMapping("/informes")
    public String mostrarInformes(Model model) {
        List<Object[]> ventasPorTipoFlor = informeService.obtenerVentasPorTipoFlor();
        model.addAttribute("ventas", ventasPorTipoFlor);
        return "informes/listar"; 
    }
}
