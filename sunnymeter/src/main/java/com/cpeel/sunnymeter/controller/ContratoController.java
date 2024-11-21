package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Contrato;
import com.cpeel.sunnymeter.service.ContratoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public Contrato criarContrato(@RequestBody Contrato contrato) {
        return contratoService.criarContrato(contrato);
    }

    @GetMapping("/{contratoUuid}")
    public Optional<Contrato> buscarContrato(@PathVariable UUID contratoUuid) {
        return contratoService.buscarContrato(contratoUuid);
    }

    @DeleteMapping("/{contratoUuid}")
    public boolean deletarContrato(@PathVariable UUID contratoUuid) {
        return contratoService.deletarContrato(contratoUuid);
    }
}