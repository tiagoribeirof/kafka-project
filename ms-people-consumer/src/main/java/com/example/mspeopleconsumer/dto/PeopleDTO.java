package com.example.mspeopleconsumer.dto;

import com.example.mspeopleconsumer.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PeopleDTO implements Serializable {

    private String name;
    private int age;
    private String adress;
    private Gender gender;
    private String maritalState;
    private String cpf;


}
