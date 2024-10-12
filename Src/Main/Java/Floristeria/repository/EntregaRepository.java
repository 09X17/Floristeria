package Floristeria.repository;

import Floristeria.entity.Entrega; // Asegúrate de que esta clase exista
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    // Puedes agregar métodos personalizados si es necesario
}
