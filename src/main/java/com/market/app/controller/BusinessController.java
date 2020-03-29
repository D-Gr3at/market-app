package com.market.app.controller;

import com.market.app.dto.BusinessDto;
import com.market.app.exception.BusinessAlreadyExistException;
import com.market.app.model.Business;
import com.market.app.repository.BusinessRepository;
import com.market.app.serviceimpl.BusinessServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;

@RestController("/account")
public class BusinessController {
    @Inject
    BusinessRepository businessRepository;
    @Inject
    BusinessServiceImpl businessService;

    @PostMapping("/create-profile")
    public ResponseEntity<Business> createBusinessAccount(BusinessDto dto){
        Optional<Business> business = businessRepository.findByBusinessEmail(dto.getBusinessEmail());
        business.ifPresent(business1 -> {
            try {
                throw new BusinessAlreadyExistException(String.format("Business name %s already exist", business1.getBusinessName()));
            } catch (BusinessAlreadyExistException e) {
                e.printStackTrace();
            }
        });
        Business newBusinessAccount = businessService.createBusiness(dto);
        return new ResponseEntity<>(newBusinessAccount, HttpStatus.OK);
    }
}
