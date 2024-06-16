package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.RatingDto;
import com.example.fooddelivery.Dto.RatingDto;
import com.example.fooddelivery.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingService {

    RatingDto createRating(RatingDto ratingDto, Integer userId, Integer resturentId);

    // All Ratings
    List<RatingDto> getAllRatings();

    // Single Rating
    RatingDto getSingleRating(Integer ratingId);

    //Update Rating
    RatingDto updateRating(RatingDto ratingDto, Integer ratingId);

    // Delete Rating
    String deleteRating(Integer ratingId);
}
