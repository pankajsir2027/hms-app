package com.hms.repository;

import com.hms.entity.AppUser;
import com.hms.entity.Property;
import com.hms.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //findByUserId
    List<Review> findByAppUser(AppUser user);

    //findbyuserandproperty
    boolean existsByAppUserAndProperty(AppUser user, Property property);

}