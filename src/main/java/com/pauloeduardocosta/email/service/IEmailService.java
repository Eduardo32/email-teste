package com.pauloeduardocosta.email.service;

import com.pauloeduardocosta.email.dto.NovoEmailDTO;

public interface IEmailService {

    String enviarEmail(NovoEmailDTO novoEmailDTO);
}
