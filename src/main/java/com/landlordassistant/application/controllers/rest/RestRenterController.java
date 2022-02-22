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
    private Renter getRenter(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        return renter;
    }


    @PostMapping
    private Renter addNewRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return renter;
    }

    @PutMapping
    private Renter updateRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return renter;
    }

    @DeleteMapping("/{id}")
    private Renter deleteRenter(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        renterService.deleteRenter(id);
        return renter;
    }
}
