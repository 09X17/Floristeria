package Floristeria.service;

import Floristeria.entity.Flor;
import Floristeria.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlorService {

    @Autowired
    private FlorRepository florRepository;

    public List<Flor> findAll() {
        return florRepository.findAll();
    }

    public Flor save(Flor flor) {
    if (flor.getCantidadDisponible() == null) {
        throw new IllegalArgumentException("La cantidad disponible no puede ser nula");
    }
    return florRepository.save(flor);
}

    public Flor findById(Long id) {
        Optional<Flor> optionalFlor = florRepository.findById(id);
        return optionalFlor.orElse(null);
    }

    public void deleteById(Long id) {
        florRepository.deleteById(id);
    }
}
