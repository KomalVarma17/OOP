package com.oop.oop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    // Custom query to find vendors by name
    Optional<Vendor> findByName(String name);

    // Custom query to find vendors by location
    List<Vendor> findByLocation(String location);

    // Custom query to find vendors by type
    List<Vendor> findByType(String type);

    // Find a vendor by its ID
    Optional<Vendor> findById(int vendorId);
}
