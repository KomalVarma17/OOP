package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Fetch all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Fetch an event by its ID
    public Event getEventById(int eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        return event.orElse(null); // Return null if the event is not found
    }

    // Save or update an event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // Delete an event by its ID
    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
    }

    // Fetch events by their status (example: Confirmed, Pending)
    public List<Event> getEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    // Fetch events by their event type (e.g., Birthday, Wedding)
    public List<Event> getEventsByType(String eventType) {
        return eventRepository.findByEventType(eventType);
    }

    // Update the status of an event (e.g., Confirmed, Pending)
    public Event updateEventStatus(int eventId, String newStatus) {
        Event event = getEventById(eventId);
        if (event != null) {
            event.setStatus(newStatus);
            return eventRepository.save(event); // Save the updated event
        }
        return null; // Return null if the event is not found
    }

   
