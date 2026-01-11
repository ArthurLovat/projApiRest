package com.example.demo.paciente;

import com.example.demo.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
