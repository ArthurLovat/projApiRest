package com.example.demo.domain.medico;

public record DadosListagemMedicos(

        Long ID,
        String nome,
        String email,
        String crm,
        Especialidade especialidade

) {

    public DadosListagemMedicos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
