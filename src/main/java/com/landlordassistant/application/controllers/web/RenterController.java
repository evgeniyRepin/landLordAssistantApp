package com.landlordassistant.application.controllers.web;

import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.services.RenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/renters")
public class RenterController {

    private final RenterService renterService;

    public RenterController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping
    public String getRenters(Model model) {
        return "renters/list";
    }


}
