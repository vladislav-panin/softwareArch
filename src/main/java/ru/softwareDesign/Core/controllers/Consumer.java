package ru.softwareDesign.Core.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class Consumer {

    private KafkaTemplate<String, String> kafkaTemplate;
}
