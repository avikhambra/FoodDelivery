package com.example.fooddelivery.Repositry;

import com.example.fooddelivery.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
