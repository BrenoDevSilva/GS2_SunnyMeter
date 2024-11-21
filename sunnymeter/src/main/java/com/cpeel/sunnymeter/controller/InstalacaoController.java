package com.cpeel.sunnymeter.controller;

import com.cpeel.sunnymeter.model.Instalacao;
import com.cpeel.sunnymeter.service.InstalacaoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {

    @Autowired
    private InstalacaoService instalacaoService;

    @PostMapping
    public Instalacao criarInstalacao(@RequestBody Instalacao instalacao) {
        return instalacaoService.criarInstalacao(instalacao);
    }

    @GetMapping
    public List<Instalacao> listarInstalacoes() {
        return instalacaoService.listarInstalacoes();
    }

    @GetMapping("/{instalacaoUuid}")
    public Optional<Instalacao> buscarInstalacao(@PathVariable UUID instalacaoUuid) {
        return instalacaoService.buscarInstalacao(instalacaoUuid);
    }

    @DeleteMapping("/{instalacaoUuid}")
    public boolean deletarInstalacao(@PathVariable UUID instalacaoUuid) {
        return instalacaoService.deletarInstalacao(instalacaoUuid);
    }
}
