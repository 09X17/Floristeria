package Floristeria.service;

import Floristeria.entity.DetalleFactura;
import Floristeria.entity.Factura;
import Floristeria.entity.Pago; 
import Floristeria.entity.Pedido;
import Floristeria.repository.FacturaRepository;
import Floristeria.repository.PagoRepository; 
import Floristeria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagoRepository pagoRepository; 

    public Factura generarFactura(Long idPedido) {
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        Factura factura = new Factura();
        factura.setFecha(LocalDate.now());
        factura.setIdPedido(idPedido);
        factura.setDetalles(generarDetallesFactura(pedido));
        factura.setTotal(calcularTotal(factura.getDetalles()));

        return facturaRepository.save(factura); 
    }

    private List<DetalleFactura> generarDetallesFactura(Pedido pedido) {
        List<DetalleFactura> detalles = new ArrayList<>();

        DetalleFactura detalle = new DetalleFactura();
        detalle.setNombreFlor(pedido.getTipoArreglo()); 
        detalle.setPrecioUnitario(BigDecimal.valueOf(pedido.getPresupuesto())); 
        detalle.setSubtotal(detalle.getPrecioUnitario()); 

        detalles.add(detalle); 
        return detalles;
    }

    private BigDecimal calcularTotal(List<DetalleFactura> detalles) {
        return detalles.stream()
                .map(DetalleFactura::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void registrarPago(Long idFactura, String metodoPago) {
        Factura factura = facturaRepository.findById(idFactura)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        

        Pago pago = new Pago();
        pago.setFactura(factura); 
        pago.setMetodoPago(metodoPago);
        pago.setMonto(factura.getTotal()); 
        pago.setFechaPago(LocalDate.now()); 

        pagoRepository.save(pago); 

        factura.setMetodoPago(metodoPago);
        facturaRepository.save(factura); 
    }

    public Factura findById(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada")); 
    }

    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }
}
