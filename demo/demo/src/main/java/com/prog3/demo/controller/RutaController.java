package com.prog3.demo.controller;


import com.prog3.demo.model.Ruta;
import com.prog3.demo.model.Usuario;
import com.prog3.demo.service.PlanificadorRutasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class RutaController {


    private final PlanificadorRutasService service;


    public RutaController(PlanificadorRutasService service) {
        this.service = service;
    }


    @GetMapping("/ruta/minima")
    public Ruta rutaMinima(@RequestParam Long origenId, @RequestParam Long destinoId) {
        return service.calcularRutaMinima(origenId, destinoId);
    }
    


    @PostMapping("/greedy")
    public ResponseEntity<Ruta> rutaGreedy(@RequestBody GreedyRequest req) {
        Ruta r = service.generarRutaGreedy(req.origenId, req.lugaresDeseados);
        return ResponseEntity.ok(r);
    }


    @PostMapping("/optimizar/dp")
    public ResponseEntity<Ruta> optimizarDP(@RequestBody OptimizarRequest req) {
        Ruta r = service.optimizarItinerarioDP(req.usuario, req.lugaresDeseados);
        return ResponseEntity.ok(r);
    }


    @PostMapping("/backtracking")
    public ResponseEntity<List<Ruta>> backtracking(@RequestBody OptimizarRequest req) {
        List<Ruta> res = service.generarItinerariosBacktracking(req.usuario, req.lugaresDeseados);
        return ResponseEntity.ok(res);
    }


    @PostMapping("/branchbound")
    public ResponseEntity<Ruta> branchAndBound(@RequestBody OptimizarRequest req) {
        Ruta r = service.optimizarBranchAndBound(req.usuario, req.lugaresDeseados);
        return ResponseEntity.ok(r);
    }


    // DTOs internos para requests
    public static class GreedyRequest {
        public String origenId;
        public List<String> lugaresDeseados;
    }


    public static class OptimizarRequest {
        public Usuario usuario;
        public List<String> lugaresDeseados;
    }
}
