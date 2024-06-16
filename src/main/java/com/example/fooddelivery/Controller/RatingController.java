package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.RatingDto;
import com.example.fooddelivery.Service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private RatingService ratingService;

    @PostMapping("/user/{userId}/resturent/{resturentId}")
    public ResponseEntity<RatingDto> createRating(
            @RequestBody RatingDto ratingDto,
            @PathVariable Integer userId,
            @PathVariable Integer resturentId){
        RatingDto ratingDto1 = ratingService.createRating(ratingDto,userId,resturentId);
        return new ResponseEntity<>(ratingDto1, HttpStatus.CREATED);
    }

    // All Ratings
    @GetMapping("/allRatings")
    ResponseEntity<List<RatingDto>> AllRatings(){
        List<RatingDto> ratingDtos = ratingService.getAllRatings();
        return new ResponseEntity<>(ratingDtos, HttpStatus.OK);
    };

    // Single Rating
    @GetMapping("/{ratingId}")
    ResponseEntity<RatingDto> SingleRating(@PathVariable Integer ratingId){
        RatingDto ratingDto = ratingService.getSingleRating(ratingId);
        return new ResponseEntity<>(ratingDto, HttpStatus.OK);
    };

    //Update Rating
    @PostMapping("/{ratingId}")
    ResponseEntity<RatingDto> updateRating(
            @RequestBody RatingDto ratingDto,
            @PathVariable Integer ratingId){
        RatingDto ratingDto1 = ratingService.updateRating(ratingDto,ratingId);
        return new ResponseEntity<>(ratingDto1, HttpStatus.OK);
    };

    // Delete Rating
    @DeleteMapping("/{ratingId}")
    ResponseEntity<String> deleteRating(@PathVariable Integer ratingId){
      ratingService.deleteRating(ratingId);
        return new ResponseEntity<>("Rating Deleted", HttpStatus.OK);
    };
}
