package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.RatingDto;
import com.example.fooddelivery.Model.Rating;
import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Model.Users;
import com.example.fooddelivery.Repositry.RatingRepo;
import com.example.fooddelivery.Repositry.ResturentRepo;
import com.example.fooddelivery.Repositry.UsersRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService{

    private ModelMapper modelMapper;
    private RatingRepo ratingRepo;
    private UsersRepo usersRepo;
    private ResturentRepo resturentRepo;


    @Override
    public RatingDto createRating(RatingDto ratingDto, Integer userId, Integer resturentId) {
        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not found"));
        Resturent resturent = resturentRepo.findById(resturentId).orElseThrow(()-> new RuntimeException("Resturent not found"));

        Rating rating = DtoToRating(ratingDto);
        rating.setUserId(users);
        rating.setResturentId(resturent);

        Rating rating1 = ratingRepo.save(rating);
        return ratingToDto(rating1);
    }

    @Override
    public List<RatingDto> getAllRatings() {
        List<Rating> ratings = ratingRepo.findAll();
        return ratings.stream().map(rat-> ratingToDto(rat)).collect(Collectors.toList());
    }

    @Override
    public RatingDto getSingleRating(Integer ratingId) {
        Rating rating = ratingRepo.findById(ratingId).get();
        return ratingToDto(rating);
    }

    @Override
    public RatingDto updateRating(RatingDto ratingDto, Integer ratingId) {
        Rating rating = ratingRepo.findById(ratingId).get();
        rating.setRating(ratingDto.getRating());
        Rating rating1 = ratingRepo.save(rating);
        return ratingToDto(rating1);
    }

    @Override
    public String deleteRating(Integer ratingId) {
        Rating rating = ratingRepo.findById(ratingId).get();
        ratingRepo.delete(rating);
        return "";
    }


    // Model Mapper
    Rating DtoToRating(RatingDto ratingDto){
        return modelMapper.map(ratingDto, Rating.class);
    }
    RatingDto ratingToDto(Rating rating){
        return modelMapper.map(rating, RatingDto.class);
    }
}
