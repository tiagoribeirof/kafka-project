package com.example.mspeopleconsumer.converter;


import com.example.mspeopleconsumer.dto.PeopleDTO;
import com.example.mspeopleconsumer.models.People;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PeoplerMapper {

    People peopleDTOToPeople(PeopleDTO peopleDTO);
}
