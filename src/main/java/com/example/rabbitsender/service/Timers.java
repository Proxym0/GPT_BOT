package com.example.rabbitsender.service;

import com.example.rabbitsender.entity.EmailMessage;
import com.example.rabbitsender.service.impl.EmailSenderServiceImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TimerTask;

@Service
public class Timer {
    private Timer timer;
    private MessageQueue messageQueue;
    private EmailSenderServiceImpl senderService;

    public Timer(MessageQueue messageQueue, EmailSenderServiceImpl senderService) {
        this.messageQueue = messageQueue;
        this.senderService = senderService;
    }

    @PostConstruct
    public void initTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                List<EmailMessage> messages = messageQueue.get();
                for (EmailMessage emailMessage : messages) {
                    senderService.sendMail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
                }
            }
        };
        timer=new Timer("Timer");
    }
    @PreDestroy
    
}
