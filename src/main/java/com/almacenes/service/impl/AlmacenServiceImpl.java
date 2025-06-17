package com.almacenes.service.impl;

import com.almacenes.model.Almacen;
import com.almacenes.repository.AlmacenRepository;
import com.almacenes.service.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public Almacen crear(Almacen almacen) {
        String clave = almacen.getSede().getClave() + "-A" + System.currentTimeMillis();
        almacen.setClave(clave);
        almacen.setFechaRegistro(LocalDate.now());
        return almacenRepository.save(almacen);
    }

    @Override
    public List<Almacen> listar() {
        return almacenRepository.findAll();
    }

    @Override
    public Almacen obtenerPorId(Long id) {
        return almacenRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        almacenRepository.deleteById(id);
    }
}