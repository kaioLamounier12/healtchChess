package com.medical.management.controller;

import com.medical.management.model.Medico;
import com.medical.management.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/paciente")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    public ResponseEntity<Medico> create(@Valid @RequestBody Medico medico) {
        return ResponseEntity.ok(medicoRepository.save(medico));
    }

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() {
        return ResponseEntity.ok(medicoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable UUID id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable UUID id, @Valid @RequestBody Medico medicoDetails) {
        return medicoRepository.findById(id).map(medico -> {
            medico.setNome(medicoDetails.getNome());
            medico.setEspecialidade(medicoDetails.getEspecialidade());
            medico.setCrm(medicoDetails.getCrm());
            medico.setEmail(medicoDetails.getEmail());
            return ResponseEntity.ok(medicoRepository.save(medico));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}