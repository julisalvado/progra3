package com.prog3.demo.service;

import com.prog3.demo.algorithm.Dijkstra;
import com.prog3.demo.model.Conexion;
import com.prog3.demo.model.Lugar;
import com.prog3.demo.model.Ruta;
import com.prog3.demo.model.Usuario;
import com.prog3.demo.repo.LugarRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlanificadorRutasService {

    private final LugarRepository lugarRepository;

    public PlanificadorRutasService(LugarRepository lugarRepository) {
        this.lugarRepository = lugarRepository;
    }

    /**
     * Calcula la ruta mínima entre dos lugares usando Dijkstra
     * Maneja errores si origen/destino no existen o no hay camino
     */
    public Ruta calcularRutaMinima(Long origenId, Long destinoId) {
        // 🔹 Traer todos los lugares con sus conexiones y depurar
        List<Lugar> lugares = lugarRepository.obtenerLugaresConConexiones();
        System.out.println("Cantidad de lugares encontrados: " + lugares.size());
        for (Lugar l : lugares) {
            System.out.println("Lugar: " + l.getNombre());
            if (l.getConexiones() != null) {
                for (Conexion c : l.getConexiones()) {
                    System.out.println("  -> conecta con " + c.getDestino().getNombre() +
                                    " (" + c.getDistanciaKm() + " km)");
                }
            } else {
                System.out.println("  -> sin conexiones");
            }
        }

        // 2️⃣ construir grafo en memoria
        Map<Long, List<Dijkstra.ConexionInterna>> grafo = new HashMap<>();
        Map<Long, Lugar> todosLosLugares = new HashMap<>();
        for (Lugar l : lugares) {
            todosLosLugares.put(l.getId(), l);
            List<Dijkstra.ConexionInterna> conexiones = new ArrayList<>();
            if (l.getConexiones() != null) {
                for (Conexion c : l.getConexiones()) {
                    conexiones.add(new Dijkstra.ConexionInterna(c.getDestino().getId(), c.getDistanciaKm()));
                }
            }
            grafo.put(l.getId(), conexiones);
        }

        // 🔹 depuración: imprimir grafo
        System.out.println("Grafo:");
        grafo.forEach((id, lista) -> {
            System.out.print("Nodo " + id + " -> ");
            lista.forEach(c -> System.out.print(c.getDestinoId() + "(" + c.getDistancia()+ ") "));
            System.out.println();
        });

        System.out.println("=== Lugares cargados desde Neo4j ===");

        // 3️⃣ calcular ruta mínima con Dijkstra
        try {
            return Dijkstra.calcularRuta(origenId, destinoId, grafo, todosLosLugares);
        } catch (IllegalArgumentException ex) {
            return new Ruta(new ArrayList<>(), Double.MAX_VALUE, 0, 0);
        }
    }

    // BFS: lugares alcanzables desde un origen con un radio (km)
    public List<Lugar> bfsLugaresAlcanzables(String origenId, double radioKm) {
        // TODO: implementar usando Neo4j o grafo en memoria
        return List.of();
    }

    // Prim / Kruskal: red mínima que conecte los lugares
    public List<String> generarRedMinima() {
        // TODO: implementar
        return List.of();
    }

    // Greedy: heurística "vecino más cercano" para generar ruta rápida
    public Ruta generarRutaGreedy(String origenId, List<String> lugaresDeseados) {
        // TODO: implementar
        return null;
    }

    // Ordenar: quicksort / mergesort wrapper
    public List<Lugar> ordenarLugares(List<Lugar> lista, String criterio) {
        // TODO: delegar a algoritmo de ordenamiento
        return lista;
    }

    // Programación dinámica: optimizar itinerario under time constraint
    public Ruta optimizarItinerarioDP(Usuario usuario, List<String> lugaresDeseados) {
        // TODO: implementar DP
        return null;
    }

    // Backtracking: generar combinaciones válidas
    public List<Ruta> generarItinerariosBacktracking(Usuario usuario, List<String> lugaresDeseados) {
        // TODO: implementar
        return List.of();
    }

    // Branch & Bound: optimizar con poda
    public Ruta optimizarBranchAndBound(Usuario usuario, List<String> lugaresDeseados) {
        // TODO: implementar
        return null;
    }
}