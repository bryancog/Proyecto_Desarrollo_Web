package co.edu.javeriana.CaravanaMedieval.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Ciudad origen;
    
    @ManyToOne
    private Ciudad destino;
    
    private boolean segura;
    private double longitud;
    private int dano;
    private String causa;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Ciudad getOrigen() { return origen; }
    public void setOrigen(Ciudad origen) { this.origen = origen; }
    
    public Ciudad getDestino() { return destino; }
    public void setDestino(Ciudad destino) { this.destino = destino; }
    
    public boolean isSegura() { return segura; }
    public void setSegura(boolean segura) { this.segura = segura; }
    
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
    
    public int getDano() { return dano; }
    public void setDano(int dano) { this.dano = dano; }
    
    public String getCausa() { return causa; }
    public void setCausa(String causa) { this.causa = causa; }
}
