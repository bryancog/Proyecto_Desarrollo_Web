package co.edu.javeriana.CaravanaMedieval.repository;

import co.edu.javeriana.CaravanaMedieval.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> { }
