package com.example.demo.domain.paciente;

import com.example.demo.domain.endereco.Endereco;

public record DadosPacienteDetalhado(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {

    public DadosPacienteDetalhado(Paciente paciente){
        this(paciente.getId(), paciente.getAtivo(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
