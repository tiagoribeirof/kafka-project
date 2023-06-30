package com.example.mspessoaconsumer.models;

import com.example.mspessoaconsumer.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "People")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String adress;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String maritalState;
    private String cpf;

}
