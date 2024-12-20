package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {

    // Find EventType by name
    Optional<EventType> findByTypeName(String typeName);
}
