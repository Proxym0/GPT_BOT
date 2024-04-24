package com.example.rabbitsender.service.impl;

import com.example.rabbitsender.service.EmailSenderService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service

public class MessagingService implements EmailSenderService {

private final JavaMailSender mailSender;

    public MessagingService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    public void sendMail(String to, String subject, String message) {
        this.mailSender.send();

    }
}
