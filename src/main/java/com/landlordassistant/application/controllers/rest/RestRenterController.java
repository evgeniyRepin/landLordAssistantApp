package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.api.RenterInfo;
import com.landlordassistant.application.dto.ResponseDto;
import com.landlordassistant.application.services.RenterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/renters")
public class RestRenterController {
    private RenterService renterService;

    public RestRenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping("/{id}")
    public ResponseDto<RenterInfo> getRenterInfo(@PathVariable long id) {
        RenterInfo renterInfo = renterService.getRenterInfo(id);
        return ResponseDto.success(renterInfo);
    }

    @GetMapping
    public ResponseDto<List<RenterInfo>> getAllRentersInfo() {
        List<RenterInfo> rentersInfo = renterService.getAllRentersInfo();
        return ResponseDto.success(rentersInfo);
    }

    @PostMapping
    public ResponseDto<Void> addNewRenterInfo(@RequestBody RenterInfo renterInfo) {
        renterService.saveRenterInfo(renterInfo);
        return ResponseDto.success();
    }

    @PutMapping
    public ResponseDto<Void> updateRenterInfo(@RequestBody RenterInfo renterInfo) {
        renterService.saveRenterInfo(renterInfo);
        return ResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> deleteRenter(@PathVariable long id) {
        renterService.deleteRenterInfo(id);
        return ResponseDto.success();
    }
}
