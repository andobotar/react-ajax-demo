package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public DemoController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @Scheduled(fixedDelay = 2000)
    public void doSth() {
         simpMessagingTemplate.convertAndSend("/topic/kutza", "{\"lofasz\": \"lopina\"}");
    }

}
