package com.almacenes.service;

import com.almacenes.dto.ClienteDTO;
import com.almacenes.model.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente crear(Cliente cliente);
    Cliente crearDesdeDTO(ClienteDTO dto);
    List<Cliente> listar();
    Cliente obtenerPorId(Long id);
    void eliminar(Long id);
}