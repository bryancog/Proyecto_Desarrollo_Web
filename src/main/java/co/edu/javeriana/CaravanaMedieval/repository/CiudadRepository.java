package co.edu.javeriana.CaravanaMedieval.repository;

import co.edu.javeriana.CaravanaMedieval.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> { }
