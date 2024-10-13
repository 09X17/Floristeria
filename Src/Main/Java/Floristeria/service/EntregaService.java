package Floristeria.service;

import jakarta.persistence.EntityNotFoundException;
import Floristeria.entity.Entrega;
import Floristeria.entity.EstadoEntrega;
import Floristeria.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private NotificacionService notificacionService;

    @Transactional
    public Entrega crearEntrega(Entrega entrega) {
        if (entrega == null) {
            throw new NullPointerException("Entrega no puede ser null");
        }
        return entregaRepository.save(entrega);
    }

    @Transactional
    public void actualizarEstadoEntrega(Long id, EstadoEntrega estado) {
        if (id == null) {
            throw new NullPointerException("Id de entrega no puede ser null");
        }
        if (estado == null) {
            throw new NullPointerException("Estado de entrega no puede ser null");
        }
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrega no encontrada"));
        entrega.setEstadoEntrega(estado);
        entregaRepository.save(entrega);
    }

    public void notificarClienteSobreEntrega(Long id) {
        if (id == null) {
            throw new NullPointerException("Id de entrega no puede ser null");
        }
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrega no encontrada"));

        if (entrega.getPedido() != null) {
            String contactoCliente = entrega.getPedido().getContactoCliente();
            notificacionService.enviarNotificacion(contactoCliente, "El estado de su entrega es: " + entrega.getEstadoEntrega());
        } else {
            throw new IllegalStateException("No se puede notificar al cliente porque la entrega no tiene un pedido asociado");
        }
    }

    public List<Entrega> obtenerEntregas() {
        return entregaRepository.findAll();
    }
}  
