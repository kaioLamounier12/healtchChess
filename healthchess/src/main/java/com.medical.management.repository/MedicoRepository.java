package com.medical.management.repository;

import com.medical.management.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {}