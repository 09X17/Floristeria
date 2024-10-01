package Floristeria.service;

import Floristeria.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformeService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Object[]> obtenerVentasPorTipoFlor() {
        return ventaRepository.findVentasPorTipoFlor();
    }
}
