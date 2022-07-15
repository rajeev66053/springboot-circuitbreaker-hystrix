package com.java.ordermanagement.service.hystrix;

import com.java.ordermanagement.dto.Seller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRegistrationHystrix {
    Logger logger = LoggerFactory.getLogger(UserRegistrationHystrix.class);
    private RestTemplate restTemplate;

    public UserRegistrationHystrix(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackForRegisterSeller", commandKey = "ordermanagement")    //this commandkey should match with the name in application.yaml
    public String registerSeller(Seller seller) {
        String response = restTemplate.postForObject("/addSeller", seller, String.class);
        return response;
    }

    public List<Seller> getSellersList() {
        return restTemplate.getForObject("/sellersList", List.class);
    }

    public String fallbackForRegisterSeller(Seller sellerDto, Throwable t) {
        logger.error("Inside fall back, cause - {}", t.toString());
        return "Inside fallback method. Some error occured while calling service for seller registration";
    }
}