package com.almacenes.service;

import com.almacenes.model.Sede;
import java.util.List;

public interface SedeService {
    Sede crear(Sede sede);
    List<Sede> listar();
    Sede obtenerPorId(Long id);
    void eliminar(Long id);
}