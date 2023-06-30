package com.example.mspeopleconsumer.listener;

import com.example.mspeopleconsumer.dto.PeopleDTO;
import com.example.mspeopleconsumer.service.PeopleService;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class PeopleListener {

    private final PeopleService peopleService;

    @KafkaListener(topics = "people-topic", groupId = "group-1", containerFactory = "jsonContainerFactory")
    public void accept(@Payload PeopleDTO people){
        log.info("Receiving people name : " + people.getName());
        peopleService.save(people);

    }
}
