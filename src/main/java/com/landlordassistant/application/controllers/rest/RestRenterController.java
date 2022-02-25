package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/renters")
public class RestRenterController {
    private RenterService renterService;

    public RestRenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping
    public List<Renter> getAllRenter() {
        List<Renter> renters = renterService.getAllRenters();
        return renters;
    }

    @GetMapping("/{id}")
    public Renter getRenter(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        return renter;
    }


    @PostMapping
    public Renter addNewRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return renter;
    }

    @PutMapping
    public Renter updateRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return renter;
    }

    @DeleteMapping("/{id}")
    public Renter deleteRenter(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        renterService.deleteRenter(id);
        return renter;
    }

    public String welcome() {
        return "Welcome";
    }
}
