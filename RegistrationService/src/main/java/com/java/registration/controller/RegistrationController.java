package com.java.registration.controller;

import com.java.registration.dto.Seller;
import com.java.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody Seller sellerDto) {
        return registrationService.addSeller(sellerDto);
    }

    @GetMapping("/sellersList")
    public List<Seller> getSellersList() {
        return registrationService.getSellersList();
    }
}