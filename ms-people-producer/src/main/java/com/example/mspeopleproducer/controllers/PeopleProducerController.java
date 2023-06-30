package com.example.mspeopleproducer.controllers;

import com.example.mspeopleproducer.models.PeopleDTO;
import com.example.mspeopleproducer.services.PeopleProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/people")
public class PeopleProducerController {

    private final PeopleProducerService peopleProducerService;

    @PostMapping
    public ResponseEntity<?> sendPeople(@RequestBody @Valid PeopleDTO people){
        peopleProducerService.sendPeople(people);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
