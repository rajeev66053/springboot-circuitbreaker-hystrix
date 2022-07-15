package com.java.registration.service;

import com.java.registration.dto.Seller;

import java.util.List;

public interface RegistrationService {

    String addSeller(Seller seller);

    List<Seller> getSellersList();
}