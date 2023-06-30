package com.example.mspessoaproducer.services;

import com.example.mspessoaproducer.models.PeopleDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PeopleProducerService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void sendPeople(PeopleDTO peopleDTO){
        try {
            log.info("Sending to kafka : " + peopleDTO.getName());
            kafkaTemplate.send("people-topic", peopleDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error when sending message to Kafka", e);
        }
    }
}
