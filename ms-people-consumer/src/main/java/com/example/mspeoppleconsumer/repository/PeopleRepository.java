package com.example.mspeoppleconsumer.repository;

import com.example.mspeoppleconsumer.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
