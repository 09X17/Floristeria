package Floristeria.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EstadoEntrega estadoEntrega;

    private LocalDateTime fechaProgramada;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Entrega() {}

    public Entrega(EstadoEntrega estadoEntrega, LocalDateTime fechaProgramada, Conductor conductor, Pedido pedido) {
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
        this.estadoEntrega = estadoEntrega;
    }

    public LocalDateTime getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(LocalDateTime fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

