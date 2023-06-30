package com.example.mspeoppleconsumer.converter;


import com.example.mspeoppleconsumer.dto.PeopleDTO;
import com.example.mspeoppleconsumer.models.People;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PeoplerMapper {

    People peopleDTOToPeople(PeopleDTO peopleDTO);
}
