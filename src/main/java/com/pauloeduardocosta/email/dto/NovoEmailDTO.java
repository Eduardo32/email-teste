package com.pauloeduardocosta.email.dto;

import lombok.Getter;

@Getter
public class NovoEmailDTO {

    private String destino;
    private String remetente;
    private String assunto;
    private String mensagem;
}
