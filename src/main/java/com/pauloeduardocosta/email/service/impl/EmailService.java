package com.pauloeduardocosta.email.service.impl;

import com.pauloeduardocosta.email.dto.NovoEmailDTO;
import com.pauloeduardocosta.email.service.IEmailService;
import com.pauloeduardocosta.email.service.exception.FalhaNoEnvioDeEmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String enviarEmail(NovoEmailDTO novoEmailDTO) {
        try {
            final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
            MimeMessage email = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(email);
            String link = "<a href=\"" + baseUrl + "/teste/\">Teste aqui</a>";
            StringBuilder mensagem = new StringBuilder()
                    .append("<p>")
                    .append(novoEmailDTO.getMensagem() + " ")
                    .append(link)
                    .append("</p>");

            helper.setSubject(novoEmailDTO.getAssunto());
            helper.setTo(novoEmailDTO.getDestino());
            helper.setFrom(novoEmailDTO.getRemetente());
            helper.setText(mensagem.toString(), true);

            mailSender.send(email);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            LOGGER.error("Falha no envio do email");
            LOGGER.trace(e.getMessage());
            throw new FalhaNoEnvioDeEmailException("Por favor, tente novamente mais tarde.");
        }
    }
}
