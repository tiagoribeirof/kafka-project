package com.example.mspeopleproducer.controller.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("Male"), FEMALE("Female");

    @JsonValue
    private String gender;

}
