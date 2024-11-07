package com.hms.controller;

import com.hms.entity.AppUser;
import com.hms.entity.Property;
import com.hms.entity.Review;
import com.hms.repository.PropertyRepository;
import com.hms.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private PropertyRepository propertyRepository;
    private ReviewRepository reviewRepository;

    public ReviewController(PropertyRepository propertyRepository, ReviewRepository reviewRepository) {
        this.propertyRepository = propertyRepository;
        this.reviewRepository = reviewRepository;
    }

    // http://localhost:8080/api/v1/review?propertryId=1
    @PostMapping
    public ResponseEntity<?> write(
            @RequestBody Review  review,
            @RequestParam long propertyId,
            @AuthenticationPrincipal AppUser user
            ) {

        Property property = propertyRepository.findById(propertyId).get();

        if(reviewRepository.existsByAppUserAndProperty
                (user, property)){
            return new ResponseEntity("Review already exists for this property", HttpStatus.CONFLICT);
        }

        review.setProperty(property);
        review.setAppUser(user);

        Review savedReview = reviewRepository.save(review);

        return new ResponseEntity(savedReview, HttpStatus.OK);



    }

    @GetMapping("/user/review")
    public ResponseEntity<List<Review>> getUserReviews(
            @AuthenticationPrincipal AppUser user
            ) {
        List<Review> reviews = reviewRepository.findByAppUser(user);
        return new ResponseEntity(reviews, HttpStatus.OK);

    }


}
