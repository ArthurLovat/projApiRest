package com.example.demo.controller;

import com.example.demo.domain.usuario.DadosCadastroUsuario;
import com.example.demo.domain.usuario.Usuario;
import com.example.demo.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {

        var senhaCriptografada = passwordEncoder.encode(dados.senha());

        var usuario = new Usuario(null, dados.login(), senhaCriptografada);
        repository.save(usuario);

        return ResponseEntity.ok().build();
    }
}