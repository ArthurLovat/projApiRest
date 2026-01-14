package com.example.demo.paciente;

import com.example.demo.endereco.Endereco;
import com.example.demo.medico.DadosMedicoDetalhado;

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
