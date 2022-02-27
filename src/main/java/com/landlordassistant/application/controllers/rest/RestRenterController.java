package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.dto.ResponseDto;
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
    public ResponseDto<List<Renter>> getAllRentersDto() {
        List<Renter> renters = renterService.getAllRenters();
        return ResponseDto.success(renters);
    }

    @GetMapping("/{id}")
    public ResponseDto<Renter> getRenterDto(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        return ResponseDto.success(renter);
    }

    @PostMapping
    public ResponseDto<Void> addNewRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return ResponseDto.success();
    }

    @PutMapping
    public ResponseDto<Void> updateRenter(@RequestBody Renter renter) {
        renterService.saveRenter(renter);
        return ResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> deleteRenter(@PathVariable long id) {
        Renter renter = renterService.getRenter(id);
        renterService.deleteRenter(id);
        return ResponseDto.success();
    }
}
