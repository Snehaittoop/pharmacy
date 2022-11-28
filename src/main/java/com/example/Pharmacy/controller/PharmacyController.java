package com.example.Pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PharmacyController {

    @KafkaListener(topics = "Prescription",groupId = "group_id")
    public void PrescriptionConsumer(String message) {

        System.out.println("message = " + message);
    }
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC3 = "MedicineComplete";
    @GetMapping("/MedicineComplete")
    public String MedicineCompleteProducer(@RequestBody String message){

        kafkaTemplate.send("MedicineComplete", message);
        return "success";}

}

