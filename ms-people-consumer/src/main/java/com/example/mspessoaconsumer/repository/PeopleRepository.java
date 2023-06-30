package com.example.mspessoaconsumer.repository;

import com.example.mspessoaconsumer.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
