package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    // Method to find an event by its ID
    Optional<Event> findById(int eventId);

    // Method to find all events by a specific status (example: Confirmed, Pending)
    List<Event> findByStatus(String status);

    // You can add more custom queries here, for example, finding events by date or name
    // Method to find events by event type (Birthday, Anniversary, etc.)
    List<Event> findByEventType(String eventType);

    
}
