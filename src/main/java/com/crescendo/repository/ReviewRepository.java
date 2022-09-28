package com.crescendo.repository;

import com.crescendo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT * FROM review WHERE business_id = :businessId", nativeQuery = true)
    List<Review> findAllReviewsByBusinessId(@Param("businessId") Long businessId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM review WHERE business_id = :businessId", nativeQuery = true)
    void deleteReviews(@Param("businessId") Long businessId);
}
