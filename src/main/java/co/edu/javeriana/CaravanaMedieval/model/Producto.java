package co.edu.javeriana.CaravanaMedieval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double factorOferta;
    private double factorDemanda;

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFactorOferta() {
        return factorOferta;
    }
    public void setFactorOferta(double factorOferta) {
        this.factorOferta = factorOferta;
    }

    public double getFactorDemanda() {
        return factorDemanda;
    }
    public void setFactorDemanda(double factorDemanda) {
        this.factorDemanda = factorDemanda;
    }
}
