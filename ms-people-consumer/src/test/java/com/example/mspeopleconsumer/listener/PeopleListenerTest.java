package com.example.mspeopleconsumer.listener;

import com.example.mspeopleconsumer.dto.PeopleDTO;
import com.example.mspeopleconsumer.listener.PeopleListener;
import com.example.mspeopleconsumer.service.PeopleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.MockConsumer;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;


@SpringBootTest
@ActiveProfiles("test")
class PeopleListenerTest {

	private static final String TOPIC = "people-topic";
	@MockBean
	private MockConsumer<String, PeopleDTO> consumer = null;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
    private PeopleListener listener;

	@MockBean
	private PeopleService service;

	private PeopleDTO peopleDTO = null;

	@BeforeEach
	void prepareConsumer() throws IOException {

		consumer = new MockConsumer<>(OffsetResetStrategy.EARLIEST);
		var url = new ClassPathResource("people.json").getURL();
		peopleDTO = mapper.readValue(url, PeopleDTO.class);

		consumer.schedulePollTask(() -> {
			consumer.rebalance(Collections.singletonList(new TopicPartition(TOPIC, 0)));
			consumer.addRecord(new ConsumerRecord<String, PeopleDTO>(TOPIC, 0, 0l, "key", peopleDTO));
		});

		HashMap<TopicPartition, Long> beginningOffsets = new HashMap<>();
		beginningOffsets.put(new TopicPartition(TOPIC, 0), 0l);
		consumer.updateBeginningOffsets(beginningOffsets);

		consumer.subscribe(Collections.singleton(TOPIC));

	}

	@Test
	public void givenPeopleMessagen_whenSendingWithSimpleProducer_thenMessageReceived() {

		listener.accept(consumer.poll(1000).records(TOPIC).iterator().next().value());
		Mockito.verify(service, Mockito.times(1)).save(peopleDTO);

	}

	}
