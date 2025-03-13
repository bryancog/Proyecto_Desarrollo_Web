package co.edu.javeriana.CaravanaMedieval.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import co.edu.javeriana.CaravanaMedieval.model.Ciudad;
import co.edu.javeriana.CaravanaMedieval.model.Jugador;
import co.edu.javeriana.CaravanaMedieval.model.Producto;
import co.edu.javeriana.CaravanaMedieval.model.Rol;
import co.edu.javeriana.CaravanaMedieval.model.Ruta;
import co.edu.javeriana.CaravanaMedieval.model.Servicio;
import co.edu.javeriana.CaravanaMedieval.repository.CiudadRepository;
import co.edu.javeriana.CaravanaMedieval.repository.JugadorRepository;
import co.edu.javeriana.CaravanaMedieval.repository.ProductoRepository;
import co.edu.javeriana.CaravanaMedieval.repository.RutaRepository;
import co.edu.javeriana.CaravanaMedieval.repository.ServicioRepository;

@Component
public class DbInitializer implements CommandLineRunner {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public void run(String... args) throws Exception {
        // 1) Crear 10 jugadores con roles asignados
        for (int i = 1; i <= 10; i++) {
            Jugador jugador = new Jugador();
            jugador.setNombre("Jugador " + i);

            // Asignar un rol de forma aleatoria o alternada
            if (i % 3 == 0) {
                jugador.setRol(Rol.ADMINISTRADOR);
            } else if (i % 2 == 0) {
                jugador.setRol(Rol.CARAVANERO);
            } else {
                jugador.setRol(Rol.COMERCIANTE);
            }

            jugadorRepository.save(jugador);
        }

        // 2) Crear 100 ciudades
        List<Ciudad> ciudades = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Ciudad ciudad = new Ciudad();
            ciudad.setNombre("Ciudad " + i);
            // Asignar un impuesto aleatorio, por ejemplo entre 5 y 20
            ciudad.setImpuesto(BigDecimal.valueOf(5 + (Math.random() * 15)));

            ciudades.add(ciudadRepository.save(ciudad));
        }

        // 3) Crear 50 productos
        for (int i = 1; i <= 50; i++) {
            Producto producto = new Producto();
            producto.setNombre("Producto " + i);
            producto.setFactorOferta(1 + Math.random() * 9);   // entre 1 y 10
            producto.setFactorDemanda(1 + Math.random() * 9); // entre 1 y 10
            productoRepository.save(producto);
        }

        // 4) Crear servicios fijos
        Servicio reparar = new Servicio();
        reparar.setNombre("Reparar");
        reparar.setPrecio(BigDecimal.valueOf(100.0));
        servicioRepository.save(reparar);

        Servicio mejorarCapacidad = new Servicio();
        mejorarCapacidad.setNombre("Mejorar capacidad");
        mejorarCapacidad.setPrecio(BigDecimal.valueOf(150.0));
        servicioRepository.save(mejorarCapacidad);

        Servicio mejorarVelocidad = new Servicio();
        mejorarVelocidad.setNombre("Mejorar velocidad");
        mejorarVelocidad.setPrecio(BigDecimal.valueOf(120.0));
        servicioRepository.save(mejorarVelocidad);

        Servicio guardias = new Servicio();
        guardias.setNombre("Guardias");
        guardias.setPrecio(BigDecimal.valueOf(200.0));
        servicioRepository.save(guardias);

        // 5) Crear rutas aleatorias entre las ciudades
        Random random = new Random();
        // Suponemos crear 150 rutas
        for (int i = 0; i < 150; i++) {
            Ruta ruta = new Ruta();

            // Seleccionar dos ciudades diferentes al azar
            Ciudad origen = ciudades.get(random.nextInt(ciudades.size()));
            Ciudad destino = ciudades.get(random.nextInt(ciudades.size()));
            while (origen.equals(destino)) {
                destino = ciudades.get(random.nextInt(ciudades.size()));
            }

            ruta.setOrigen(origen);
            ruta.setDestino(destino);

            boolean esSegura = random.nextBoolean();
            ruta.setSegura(esSegura);
            ruta.setLongitud(10 + random.nextDouble() * 90); // entre 10 y 100

            if (!esSegura) {
                ruta.setDano(5 + random.nextInt(16)); // daño entre 5 y 20
                ruta.setCausa(random.nextBoolean() ? "Bandidos" : "Desastre natural");
            } else {
                ruta.setDano(0);
                ruta.setCausa("Ruta segura");
            }

            rutaRepository.save(ruta);
        }

        System.out.println(">>> Base de datos inicializada con datos de ejemplo <<<");
    }
}
