package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.RegistroConsumo;
import com.cpeel.sunnymeter.repository.RegistroConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegistroConsumoService {

    @Autowired
    private RegistroConsumoRepository consumoRepository;

    public RegistroConsumo registrarConsumo(RegistroConsumo consumo) {
        return consumoRepository.save(consumo);
    }

    public List<RegistroConsumo> calcularConsumoMensal(UUID contratoUuid) {
        return consumoRepository.findAll();
    }
}
