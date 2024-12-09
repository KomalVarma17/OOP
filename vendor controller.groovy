package com.oop.oop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    // Display list of all vendors
    @GetMapping
    public String showVendorList(Model model) {
        List<Vendor> vendors = vendorService.getAllVendors();
        model.addAttribute("vendors", vendors);
        return "vendor_list"; // Return the vendor list view
    }

    // Display a specific vendor's details
    @GetMapping("/{id}")
    public String showVendorDetails(@PathVariable int id, Model model) {
        Vendor vendor = vendorService.getVendorById(id);
        if (vendor != null) {
            model.addAttribute("vendor", vendor);
            model.addAttribute("menuItems", vendor.getMenuItems()); // Optionally display menu items of the vendor
            model.addAttribute("events", vendor.getEvents()); // Optionally display events related to the vendor
            return "vendor_details"; // Return the vendor details view
        } else {
            return "redirect:/vendors"; // Redirect back to the vendor list if not found
        }
    }

    // Show the form for creating a new vendor
    @GetMapping("/new")
    public String showCreateVendorForm(Model model) {
        model.addAttribute("vendor", new Vendor());
        return "vendor_form"; // Return the form to create a new vendor
    }

    // Create a new vendor
    @PostMapping("/new")
    public String createVendor(@ModelAttribute Vendor vendor) {
        vendorService.saveVendor(vendor); // Save the new vendor using the service
        return "redirect:/vendors"; // Redirect to the vendor list after saving
    }

    // Show the form for editing an existing vendor
    @GetMapping("/edit/{id}")
    public String showEditVendorForm(@PathVariable int id, Model model) {
        Vendor vendor = vendorService.getVendorById(id);
        if (vendor != null) {
            model.addAttribute("vendor", vendor);
            return "vendor_form"; // Return the form to edit the vendor
        } else {
            return "redirect:/vendors"; // Redirect to vendor list if vendor not found
        }
    }

    // Update an existing vendor
    @PostMapping("/edit/{id}")
    public String updateVendor(@PathVariable int id, @ModelAttribute Vendor vendor) {
        vendor.setVendorId(id); // Set the vendor ID to ensure we update the correct vendor
        vendorService.saveVendor(vendor); // Update the vendor using the service
        return "redirect:/vendors/" + id; // Redirect to the updated vendor's details page
    }

    // Delete an existing vendor
    @GetMapping("/delete/{id}")
    public String deleteVendor(@PathVariable int id) {
        vendorService.deleteVendor(id); // Delete the vendor by ID
        return "redirect:/vendors"; // Redirect back to the vendor list after deletion
    }
}
