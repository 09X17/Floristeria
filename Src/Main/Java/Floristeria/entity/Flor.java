package Floristeria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flor")
public class Flor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo;

    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "precio_venta", nullable = false) 
    private Double precioVenta; 

    @Column(name = "precio_compra", nullable = false) 
    private Double precioCompra; 

    
    public Flor() {
    }

    
    public Flor(Integer cantidad, String nombre, String tipo, Integer cantidadDisponible, Double precioVenta, Double precioCompra) {
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadDisponible = cantidadDisponible;
        this.precioVenta = precioVenta; 
        this.precioCompra = precioCompra; 
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Double getPrecioVenta() { 
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) { 
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() { 
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) { 
        this.precioCompra = precioCompra;
    }

    
    @Override
    public String toString() {
        return "Flor{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", precioVenta=" + precioVenta + 
                ", precioCompra=" + precioCompra + 
                '}';
    }
}
