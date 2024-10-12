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
    public Entrega asignarEntrega(Entrega entrega) {
        return entregaRepository.save(entrega);
    }

    @Transactional
    public void actualizarEstado(Long id, EstadoEntrega estado) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
        entrega.setEstadoEntrega(estado);
        entregaRepository.save(entrega);
    }

    public void notificarCliente(Long id) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entrega no encontrada"));

        if (entrega.getPedido() != null) {
            String contactoCliente = entrega.getPedido().getContactoCliente();
            notificacionService.enviarNotificacion(contactoCliente, "El estado de su entrega es: " + entrega.getEstadoEntrega());
        } else {
            throw new IllegalStateException("No se puede notificar al cliente porque la entrega no tiene un pedido asociado");
        }
    }

    public List<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }
}
