package com.example.mspeopleconsumer.service;

import com.example.mspeopleconsumer.domain.Gender;
import com.example.mspeopleconsumer.dto.PeopleDTO;
import com.example.mspeopleconsumer.models.People;
import com.example.mspeopleconsumer.repository.PeopleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class PeopleServiceTest {



    @MockBean
    private  PeopleRepository repository;

    @Autowired
    private PeopleService service;


    private PeopleDTO createDTO(){
        return new PeopleDTO("Martha",20,"5th av", Gender.FEMALE, "single", "12345678910");

    }

    private People createEntity(){
        return new People(1L, "Martha", 20, "5th av",
                Gender.FEMALE, "single", "12345678910");

    }

    @Test
    public void givenPeopleDTOThenSavePeople() {
        when(repository.save(Mockito.any(People.class))).thenReturn(createEntity());
        PeopleDTO dto = createDTO();
        service.save(dto);
        verify(repository, times(1)).save(Mockito.any(People.class));
    }
}
