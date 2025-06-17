package com.almacenes.service;

import com.almacenes.model.Almacen;
import java.util.List;

public interface AlmacenService {
    Almacen crear(Almacen almacen);
    List<Almacen> listar();
    Almacen obtenerPorId(Long id);
    void eliminar(Long id);
}