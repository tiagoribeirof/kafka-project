package com.example.mspessoaproducer.models;

import com.example.mspessoaproducer.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class PeopleDTO implements Serializable {

    @NotBlank
    private String name;
    @NotNull(message = "The field cannot be null")
    @DecimalMin(value = "1", inclusive = true, message = "Invalid age")
    @DecimalMax(value = "150", inclusive = true, message = "Invalid age")
    private int age;
    @NotBlank
    private String adress;

    private Gender gender;
    @NotBlank
    private String maritalState;
    @NotBlank
    @CPF(message = "The CPF informed is not valid")
    private String cpf;


}
