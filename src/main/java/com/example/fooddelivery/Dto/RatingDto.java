package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Model.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingDto {

    private Integer ratingId;
    private Integer rating;
    private Users userId;
    private Resturent resturentId;
}
