package com.pauloeduardocosta.email.rs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteRS {

    @GetMapping
    public ResponseEntity teste() {
        return ResponseEntity.ok("Sucesso!!");
    }
}
