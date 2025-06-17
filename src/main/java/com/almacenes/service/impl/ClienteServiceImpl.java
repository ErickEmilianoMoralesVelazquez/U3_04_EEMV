package com.almacenes.service.impl;

import com.almacenes.dto.ClienteDTO;
import com.almacenes.model.Cliente;
import com.almacenes.repository.ClienteRepository;
import com.almacenes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearDesdeDTO(ClienteDTO dto) {
        try {
            String encriptado = Base64.getEncoder()
                    .encodeToString(dto.getCorreoElectronico().getBytes());

            Cliente cliente = Cliente.builder()
                    .nombreCompleto(dto.getNombreCompleto())
                    .telefono(dto.getTelefono())
                    .correoElectronico(encriptado)
                    .build();

            return clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear cliente: " + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    // Método original ya no se usa
    @Override
    public Cliente crear(Cliente cliente) {
        throw new UnsupportedOperationException("Usa crearDesdeDTO() con validación");
    }
}
