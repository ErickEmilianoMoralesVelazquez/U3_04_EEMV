package com.almacenes.controller;

import com.almacenes.model.Almacen;
import com.almacenes.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/almacenes")
@CrossOrigin
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @PostMapping
    public Almacen crear(@RequestBody Almacen almacen) {
        return almacenService.crear(almacen);
    }

    @GetMapping
    public List<Almacen> listar() {
        return almacenService.listar();
    }

    @GetMapping("/{id}")
    public Almacen obtener(@PathVariable Long id) {
        return almacenService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        almacenService.eliminar(id);
    }
}