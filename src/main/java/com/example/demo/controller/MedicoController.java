package com.example.demo.controller;

import com.example.demo.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {


    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosMedicoDetalhado(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listarMedicos(@PageableDefault(size= 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosMedicoDetalhado(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid DadosEditarMedico dadosEditar){

        var medico = repository.getReferenceById(dadosEditar.id());
        medico.editarInformacoes(dadosEditar);
        return ResponseEntity.ok(new DadosMedicoDetalhado(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();

    }

}