package Floristeria.service;

import Floristeria.entity.Pago;
import Floristeria.entity.Factura;
import Floristeria.repository.FacturaRepository;
import Floristeria.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List; 

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    public void registrarPago(Long idFactura, String metodoPago, BigDecimal monto) {
        Factura factura = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        Pago pago = new Pago();
        pago.setFactura(factura); 
        pago.setMetodoPago(metodoPago);
        pago.setMonto(monto);
        pago.setFechaPago(LocalDate.now()); 
        pagoRepository.save(pago);
    }

    public void procesarPago(Long idFactura, String metodoPago) {
        Factura factura = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        BigDecimal monto = factura.getTotal(); 
        
        registrarPago(idFactura, metodoPago, monto); 
    }

    public List<Pago> listarPagos() {
        return pagoRepository.findAll(); 
    }

    public List<Pago> obtenerPagosPorFactura(Long idFactura) {
        return pagoRepository.findByFacturaId(idFactura);
    }
}
