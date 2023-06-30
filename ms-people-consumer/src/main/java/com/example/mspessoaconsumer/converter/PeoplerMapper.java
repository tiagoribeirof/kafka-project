package com.example.mspessoaconsumer.converter;


import com.example.mspessoaconsumer.dto.PeopleDTO;
import com.example.mspessoaconsumer.models.People;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PeoplerMapper {

    People peopleDTOToPeople(PeopleDTO peopleDTO);
}
