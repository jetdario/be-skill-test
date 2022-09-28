package com.crescendo.controller.rest;

import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping(path = "/create", consumes = "application/json")
    public void create(@RequestBody Business business) {
        businessRepository.save(business);
    }

    @GetMapping(path = "/findAll", produces = "application/json")
    public List<Business> findAll() {
        return businessRepository.findAll();
    }

    @GetMapping(path = "/find/{id}", produces = "application/json")
    public Business findAll(@PathVariable("id") Long id) {
        Business business;
        if(businessRepository.findById(id).isPresent()){
            business = businessRepository.findById(id).get();
        } else {
            business = new Business();
        }

        return business;
    }

    @PutMapping(path = "/update", consumes = "application/json")
    public Business update(@RequestBody Business business) {
        return businessRepository.save(business);
    }

    @DeleteMapping(path = "/delete", consumes = "application/json")
    public void delete(@RequestBody Business business) {
        try {
            businessRepository.delete(business);
            reviewRepository.deleteReviews(business.getId());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
