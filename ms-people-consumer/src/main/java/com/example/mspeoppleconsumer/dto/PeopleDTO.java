package com.example.mspeoppleconsumer.dto;

import com.example.mspeoppleconsumer.domain.Gender;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class PeopleDTO implements Serializable {

    private String name;
    private int age;
    private String adress;
    private Gender gender;
    private String maritalState;
    private String cpf;


}
