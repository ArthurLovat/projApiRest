package com.example.demo.domain.medico;

import com.example.demo.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }


    public void editarInformacoes(@Valid DadosEditarMedico dadosEditar) {
        if (dadosEditar.nome() != null){
            this.nome = dadosEditar.nome();
        }
        if (dadosEditar.telefone() != null){
            this.telefone = dadosEditar.telefone();
        }
        if (dadosEditar.endereco() != null){
            this.endereco.editarEndereco(dadosEditar.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
