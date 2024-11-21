package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Cliente;
import com.cpeel.sunnymeter.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{clienteUuid}")
    public Optional<Cliente> buscarCliente(@PathVariable UUID clienteUuid) {
        return clienteService.buscarCliente(clienteUuid);
    }

    @DeleteMapping("/{clienteUuid}")
    public boolean deletarCliente(@PathVariable UUID clienteUuid) {
        return clienteService.deletarCliente(clienteUuid);
    }
}
