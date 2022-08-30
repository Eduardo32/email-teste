package com.pauloeduardocosta.email.rs;

import com.pauloeduardocosta.email.dto.NovoEmailDTO;
import com.pauloeduardocosta.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailRS {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity enviarEmail(@RequestBody NovoEmailDTO novoEmailDTO) {
        String resp = emailService.enviarEmail(novoEmailDTO);
        return ResponseEntity.ok(resp);
    }
}
