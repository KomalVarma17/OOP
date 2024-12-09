package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Endpoint to view all events
    @GetMapping
    public String listAllEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);  // Add events to the model to display in the view
        return "event_list";  
    }

    // Endpoint to show event details by event ID
    @GetMapping("/{eventId}")
    public String viewEventDetails(@PathVariable int eventId, Model model) {
        Event event = eventService.getEventById(eventId);
        if (event != null) {
            model.addAttribute("event", event);  // Add event details to the model
            return "event_details";  // Returns the view for event details
        } else {
            return "redirect:/events";  // Redirect to events list if event not found
        }
    }

    // Endpoint to show event creation form
    @GetMapping("/create")
    public String showEventCreationForm(Model model) {
        // You can add any necessary model attributes for dropdowns or forms (like cafes, vendors, etc.)
        model.addAttribute("event", new Event());  // Blank event to be created
        return "event_create";  // View for event creation
    }

    // Endpoint to handle the event creation form submission
    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);  // Save the event using the service layer
        return "redirect:/events";  // Redirect to event list after successful creation
    }

    // Endpoint to delete an event by event ID
    @PostMapping("/delete/{eventId}")
    public String deleteEvent(@PathVariable int eventId) {
        eventService.deleteEvent(eventId);  // Delete the event using the service layer
        return "redirect:/events";  // Redirect to event list after successful deletion
    }

    // Endpoint to update event status (example: Confirm or Cancel)
    @PostMapping("/update/{eventId}")
    public String updateEventStatus(@PathVariable int eventId, @RequestParam("status") String status) {
        eventService.updateEventStatus(eventId, status);  // Update status of the event
        return "redirect:/events/" + eventId;  // Redirect to event details after status update
    }
}
