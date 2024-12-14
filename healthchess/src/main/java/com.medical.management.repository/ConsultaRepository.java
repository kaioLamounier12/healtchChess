package com.medical.management.repository;

import com.medical.management.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> { }