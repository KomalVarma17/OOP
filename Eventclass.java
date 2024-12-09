package com.oop.oop;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int eventId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "event_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Column(name = "event_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date eventTime;

    @ManyToOne
    @JoinColumn(name = "cafe_id", referencedColumnName = "cafe_id")
    private Cafe cafe;  // Associated cafe for the event

    @ManyToMany
    @JoinTable(
        name = "event_vendors", 
        joinColumns = @JoinColumn(name = "event_id"),
        inverseJoinColumns = @JoinColumn(name = "vendor_id")
    )
    private List<Vendor> vendors;  // List of vendors for the event

    @Column(name = "status", nullable = false)
    private String status; // Status of the event (e.g., planned, confirmed, completed)

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // Payment status for the event (e.g., paid, pending)

    // Constructor
    public Event(int eventId, String eventType, Date eventDate, Date eventTime, Cafe cafe, List<Vendor> vendors, String status, String paymentStatus) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.cafe = cafe;
        this.vendors = vendors;
        this.status = status;
        this.paymentStatus = paymentStatus;
    }

    public Event() {
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
