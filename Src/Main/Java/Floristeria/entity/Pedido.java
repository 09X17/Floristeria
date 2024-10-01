package Floristeria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private String direccionCliente;

    @Column(nullable = false)
    private String contactoCliente;

    @Column(nullable = false)
    private String tipoArreglo;

    @Column(nullable = false)
    private String ocasion;

    @Column(nullable = false)
    private LocalDate fechaEntrega;

    @Column(nullable = false)
    private Double presupuesto;

    @Column(nullable = true)
    private String estado;

    public Pedido() {
    }

    public Pedido(String nombreCliente, String direccionCliente, String contactoCliente, String tipoArreglo,
                  String ocasion, LocalDate fechaEntrega, Double presupuesto, String estado) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
        this.contactoCliente = contactoCliente;
        this.tipoArreglo = tipoArreglo;
        this.ocasion = ocasion;
        this.fechaEntrega = fechaEntrega;
        this.presupuesto = presupuesto;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getContactoCliente() {
        return contactoCliente;
    }

    public void setContactoCliente(String contactoCliente) {
        this.contactoCliente = contactoCliente;
    }

    public String getTipoArreglo() {
        return tipoArreglo;
    }

    public void setTipoArreglo(String tipoArreglo) {
        this.tipoArreglo = tipoArreglo;
    }

    public String getOcasion() {
        return ocasion;
    }

    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
