package Floristeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Floristeria.entity.Flor;

public interface FlorRepository extends JpaRepository<Flor, Long> {

}
