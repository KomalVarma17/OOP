package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // Fetch all vendors
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // Fetch vendor by ID
    public Vendor getVendorById(int vendorId) {
        Optional<Vendor> vendor = vendorRepository.findById(vendorId);
        return vendor.orElse(null); // Return null if vendor not found
    }

    // Save or update a vendor
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // Delete a vendor by ID
    public void deleteVendor(int vendorId) {
        vendorRepository.deleteById(vendorId);
    }

    // Find vendors by location
    public List<Vendor> getVendorsByLocation(String location) {
        return vendorRepository.findByLocation(location);
    }

    // Find vendors by name
    public Optional<Vendor> getVendorByName(String name) {
        return vendorRepository.findByName(name);
    }

    // Find vendors by type
    public List<Vendor> getVendorsByType(String type) {
        return vendorRepository.findByType(type);
    }
}
