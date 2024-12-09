package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    // Get all event types
    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    // Get an event type by ID
    public EventType getEventTypeById(int eventTypeId) {
        Optional<EventType> eventType = eventTypeRepository.findById(eventTypeId);
        return eventType.orElse(null); // Return null if not found
    }

    // Get event type by name
    public EventType getEventTypeByName(String typeName) {
        Optional<EventType> eventType = eventTypeRepository.findByTypeName(typeName);
        return eventType.orElse(null); // Return null if not found
    }

    // Save or update event type
    public EventType saveEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    // Delete event type by ID
    public void deleteEventType(int eventTypeId) {
        eventTypeRepository.deleteById(eventTypeId);
    }
}
