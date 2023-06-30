package com.example.mspeoppleconsumer.domain;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


@Getter

public enum Gender {

    MALE("Male"), FEMALE("Female");

    @JsonValue
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

}
