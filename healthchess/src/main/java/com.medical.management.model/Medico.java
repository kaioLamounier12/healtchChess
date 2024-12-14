package com.medical.management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String nome;

    @NotBlank
    private String especialidade;

    @NotBlank
    private String crm;

    @Email
    @NotBlank
    private String email;
}
