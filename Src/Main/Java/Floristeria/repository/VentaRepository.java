package Floristeria.repository;

import Floristeria.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("SELECT v.tipoFlor, SUM(v.cantidad) AS totalCantidad, SUM(v.precio) AS totalIngresos FROM Venta v GROUP BY v.tipoFlor")
    List<Object[]> findVentasPorTipoFlor();
}
