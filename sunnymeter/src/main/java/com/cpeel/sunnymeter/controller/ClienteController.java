package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Cliente;
import com.cpeel.sunnymeter.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Método para cadastrar um cliente
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        // Chama o método do serviço para salvar o cliente
        Cliente novoCliente = clienteService.salvar(cliente);
        // Retorna a resposta com o cliente cadastrado
        return ResponseEntity.status(201).body(novoCliente);  // Retorna 201 Created
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable UUID id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        return cliente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID id) {
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
