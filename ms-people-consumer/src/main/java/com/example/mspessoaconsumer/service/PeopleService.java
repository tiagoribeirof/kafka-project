package com.example.mspessoaconsumer.service;

import com.example.mspessoaconsumer.converter.PeoplerMapper;
import com.example.mspessoaconsumer.dto.PeopleDTO;
import com.example.mspessoaconsumer.models.People;
import com.example.mspessoaconsumer.repository.PeopleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class PeopleService {


    private final PeopleRepository repository;

    private final PeoplerMapper mapper;

    public void save(PeopleDTO pessoa){
        People peopleEntity = mapper.peopleDTOToPeople(pessoa);
        People pessoaSave = repository.save(peopleEntity);
        log.info("Name : " + pessoaSave.getName() +" save with id : " + pessoaSave.getId());
    }
}
