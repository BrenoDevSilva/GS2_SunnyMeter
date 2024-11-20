package com.cpeel.sunnymeter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID clienteUuid;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O documento é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}",
            message = "O documento deve ser CPF ou CNPJ válido")
    private String documento;

    @NotBlank(message = "O tipo de cliente é obrigatório")
    @Pattern(regexp = "PF|PJ", message = "O tipo de cliente deve ser PF ou PJ")
    private String tipoCliente;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000")
    private String cep;

    @NotNull
    private Boolean ativo;
}