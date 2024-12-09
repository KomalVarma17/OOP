package com.oop.oop;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vendor_id")  // Mapping the field vendorId to the vendor_id column in the table
    private int vendorId;

    @Column(name = "name", nullable = false, length = 100)  // name with varchar(100), not nullable
    private String name;

    @Column(name = "contact_info", nullable = true, length = 100)  // contact_info with varchar(100), nullable
    private String contactInfo;

    @Column(name = "location", nullable = true, length = 255)  // location with varchar(255), nullable
    private String location;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Event> events = new ArrayList<>(); // List of events associated with this vendor

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems = new ArrayList<>(); // List of menu items associated with this vendor

    // Constructor
    public Vendor(int vendorId, String name, String contactInfo, String location) {
        this.vendorId = vendorId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.location = location;
    }

    public Vendor() {
    }

    // Getters and Setters

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    
}
