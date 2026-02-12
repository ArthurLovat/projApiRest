package com.example.demo.domain.usuario;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank String login,
        @NotBlank String senha
) {}