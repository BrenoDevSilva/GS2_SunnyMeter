package com.cpeel.sunnymeter.service;

import com.cpeel.sunnymeter.model.RegistroProducao;
import com.cpeel.sunnymeter.repository.RegistroProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistroProducaoService {

    @Autowired
    private RegistroProducaoRepository registroProducaoRepository;

    public RegistroProducao saveOrUpdateRegistroProducao(RegistroProducao registroProducao) {
        return registroProducaoRepository.save(registroProducao);
    }

    public List<RegistroProducao> getAllRegistrosProducao() {
        return registroProducaoRepository.findAll();
    }

    public Optional<RegistroProducao> getRegistroProducaoById(UUID id) {
        return registroProducaoRepository.findById(id);
    }

    public void deleteRegistroProducao(UUID id) {
        registroProducaoRepository.deleteById(id);
    }

    public List<RegistroProducao> findByDataProducao(String dataProducao) {
        return registroProducaoRepository.findByDataProducao(dataProducao);
    }
}
