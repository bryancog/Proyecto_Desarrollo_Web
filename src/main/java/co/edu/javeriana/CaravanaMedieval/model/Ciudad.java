package co.edu.javeriana.CaravanaMedieval.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ciudad {   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    private BigDecimal impuesto; 

    @OneToMany(mappedBy = "origen", cascade = CascadeType.ALL)
    private List<Ruta> rutasSalida;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public BigDecimal getImpuesto() { return impuesto; }
    public void setImpuesto(BigDecimal impuesto) { this.impuesto = impuesto; }
    
    public List<Ruta> getRutasSalida() { return rutasSalida; }
    public void setRutasSalida(List<Ruta> rutasSalida) { this.rutasSalida = rutasSalida; }
}
