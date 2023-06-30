package com.example.mspeopleproducer.controller;

import com.example.mspeopleproducer.controller.domain.Gender;
import com.example.mspeopleproducer.controller.models.PeopleDTO;
import com.example.mspeopleproducer.controller.services.PeopleProducerService;
import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.response.MockMvcResponse;
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;



import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doNothing;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class PeopleProducerControllerTest {


    @Autowired
    private WebApplicationContext context;
    @LocalServerPort
    private int port;

    @MockBean
    private PeopleProducerService peopleProducerService;

    @BeforeEach
    void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void givenPostSendKafkaMessage() {
        PeopleDTO peopleDTO = createDTO();
        doNothing().when(peopleProducerService).sendPeople(peopleDTO);
        MockMvcResponse response = RestAssuredMockMvc.given().webAppContextSetup(context)
                .contentType("application/json").body(peopleDTO).post("/people");

        response.then()
                .statusCode(is(HttpStatus.SC_CREATED));
    }




    private PeopleDTO createDTO(){
        return new PeopleDTO("Martha",20,"5th av", Gender.FEMALE, "single", "33576617051");

    }
}
