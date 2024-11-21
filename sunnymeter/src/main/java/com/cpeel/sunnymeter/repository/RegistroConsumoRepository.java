package com.cpeel.sunnymeter.repository;

import com.cpeel.sunnymeter.model.RegistroConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RegistroConsumoRepository extends JpaRepository<RegistroConsumo, UUID> {
}
