package com.example.paf.repo;

import com.example.paf.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface RatingRepo extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT * FROM rating WHERE id = ?1", nativeQuery = true )
    Rating getRatingBy(Integer ratingId);
}
