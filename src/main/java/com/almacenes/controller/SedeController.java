package com.almacenes.controller;

import com.almacenes.model.Sede;
import com.almacenes.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
@CrossOrigin
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @PostMapping
    public Sede crear(@RequestBody Sede sede) {
        return sedeService.crear(sede);
    }

    @GetMapping
    public List<Sede> listar() {
        return sedeService.listar();
    }

    @GetMapping("/{id}")
    public Sede obtener(@PathVariable Long id) {
        return sedeService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sedeService.eliminar(id);
    }
}