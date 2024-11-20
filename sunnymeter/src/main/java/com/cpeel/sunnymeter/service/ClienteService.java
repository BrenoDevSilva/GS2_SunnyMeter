package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.Cliente;
import com.cpeel.sunnymeter.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(UUID id) {
        return clienteRepository.findById(id);
    }

    public void deletarPorId(UUID id) {
        clienteRepository.deleteById(id);
    }
}
