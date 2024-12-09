package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-types")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    // Get all event types
    @GetMapping
    public List<EventType> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    // Get event type by ID
    @GetMapping("/{eventTypeId}")
    public EventType getEventTypeById(@PathVariable int eventTypeId) {
        return eventTypeService.getEventTypeById(eventTypeId);
    }

    // Get event type by name
    @GetMapping("/name/{typeName}")
    public EventType getEventTypeByName(@PathVariable String typeName) {
        return eventTypeService.getEventTypeByName(typeName);
    }

    // Save or update event type
    @PostMapping
    public EventType saveEventType(@RequestBody EventType eventType) {
        return eventTypeService.saveEventType(eventType);
    }

    // Delete event type by ID
    @DeleteMapping("/{eventTypeId}")
    public void deleteEventType(@PathVariable int eventTypeId) {
        eventTypeService.deleteEventType(eventTypeId);
    }
}
