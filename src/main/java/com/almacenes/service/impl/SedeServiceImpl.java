package com.almacenes.service.impl;

import com.almacenes.model.Sede;
import com.almacenes.repository.SedeRepository;
import com.almacenes.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

@Service
public class SedeServiceImpl implements SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public Sede crear(Sede sede) {
        String clave = "C" + LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")) +
                       "-" + (1000 + new Random().nextInt(9000));
        sede.setClave(clave);
        return sedeRepository.save(sede);
    }

    @Override
    public List<Sede> listar() {
        return sedeRepository.findAll();
    }

    @Override
    public Sede obtenerPorId(Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        sedeRepository.deleteById(id);
    }
}