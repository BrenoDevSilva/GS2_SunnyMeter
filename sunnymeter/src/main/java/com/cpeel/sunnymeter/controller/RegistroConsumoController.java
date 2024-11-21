package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.RegistroConsumo;
import com.cpeel.sunnymeter.service.RegistroConsumoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/registroconsumo")
public class RegistroConsumoController {

    @Autowired
    private RegistroConsumoService registroConsumoService;

    @PostMapping
    public RegistroConsumo registrarConsumo(@RequestBody RegistroConsumo consumo) {
        return registroConsumoService.registrarConsumo(consumo);
    }

    @GetMapping("/mensal/{contratoUuid}")
    public List<RegistroConsumo> calcularConsumoMensal(@PathVariable UUID contratoUuid) {
        return registroConsumoService.calcularConsumoMensal(contratoUuid);
    }
}