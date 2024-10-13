package Floristeria.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoEntrega estadoEntrega;

    @Column(name = "fecha_programada", nullable = false)
    private ZonedDateTime fechaProgramada;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    public Entrega() {}

    public Entrega(EstadoEntrega estadoEntrega, ZonedDateTime fechaProgramada, Conductor conductor, Pedido pedido) {
        this.estadoEntrega = estadoEntrega;
        this.fechaProgramada = fechaProgramada;
        this.conductor = conductor;
        this.pedido = pedido;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoEntrega getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(EstadoEntrega estadoEntrega) {
        if (estadoEntrega == null) {
            throw new NullPointerException("Estado de entrega no puede ser null");
        }
        this.estadoEntrega = estadoEntrega;
    }

    public ZonedDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(ZonedDateTime fechaProgramada) {
        if (fechaProgramada == null) {
            throw new NullPointerException("Fecha programada no puede ser null");
        }
        this.fechaProgramada = fechaProgramada;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        if (conductor == null) {
            throw new NullPointerException("Conductor no puede ser null");
        }
        this.conductor = conductor;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        if (pedido == null) {
            throw new NullPointerException("Pedido no puede ser null");
        }
        this.pedido = pedido;
    }
}

