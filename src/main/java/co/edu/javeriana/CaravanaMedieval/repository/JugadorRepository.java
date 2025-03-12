package co.edu.javeriana.CaravanaMedieval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.CaravanaMedieval.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
