package com.prog3.demo.controller;


import com.prog3.demo.model.Lugar;
import com.prog3.demo.service.PlanificadorRutasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/lugares")
public class LugarController {


    private final PlanificadorRutasService service;


    public LugarController(PlanificadorRutasService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Lugar>> listarTodos() {
        // TODO: obtener de repositorio
        return ResponseEntity.ok(List.of());
    }


    @GetMapping("/alcanzables")
    public ResponseEntity<List<Lugar>> alcanzables(@RequestParam String origen, @RequestParam double radioKm) {
        List<Lugar> res = service.bfsLugaresAlcanzables(origen, radioKm);
        return ResponseEntity.ok(res);
    }


    @GetMapping("/ordenar")
    public ResponseEntity<List<Lugar>> ordenar(@RequestParam String criterio) {
        // TODO: pedir lista y criterio
        return ResponseEntity.ok(List.of());
    }
}


