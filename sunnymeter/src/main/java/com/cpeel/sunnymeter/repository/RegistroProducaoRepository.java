package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.RegistroProducao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegistroProducaoRepository extends JpaRepository<RegistroProducao, UUID> {
    List<RegistroProducao> findByDataProducao(String dataProducao);
}