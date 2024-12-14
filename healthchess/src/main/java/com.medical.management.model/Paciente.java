package com.medical.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @Past
    private LocalDate dataNascimento;

    @NotBlank
    private String contato;
}