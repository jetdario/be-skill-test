package com.crescendo.controller.rest;

import com.crescendo.model.Business;
import com.crescendo.model.Review;
import com.crescendo.repository.BusinessRepository;
import com.crescendo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping(path = "/findAllReviewsByBusinessId/{id}", produces = "application/json")
    public List<Review> findAllReviewsByBusinessId(@PathVariable("id") Long id) {
        return reviewRepository.findAllReviewsByBusinessId(id);
    }

    @PostMapping(path = "/create", consumes = "application/json")
    public void create(@RequestBody Review review) {
        if(businessRepository.findById(review.getBusinessId()).isPresent()){
            reviewRepository.save(review);
        } else {
            System.out.println("Business NOT  FOUND!");
        }
    }
}
