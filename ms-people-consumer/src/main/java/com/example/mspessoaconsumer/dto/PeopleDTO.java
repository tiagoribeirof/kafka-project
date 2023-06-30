package com.example.mspessoaconsumer.dto;

import com.example.mspessoaconsumer.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
