package com.example.demo.domain.medico;

import com.example.demo.domain.endereco.Endereco;

public record DadosMedicoDetalhado(Long id,
                                   String nome,
                                   String emai,
                                   String crm,
                                   String telefone,
                                   Especialidade especialidade,
                                   Endereco endereco) {

    public DadosMedicoDetalhado(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
