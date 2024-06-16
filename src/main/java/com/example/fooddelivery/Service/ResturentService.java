package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.ResturentDto;

import java.util.List;

public interface ResturentService {

    ResturentDto addResturent(ResturentDto resturentDto);

    // All DRIVER
    List<ResturentDto> getAllResturent();

    // Single DRIER
    ResturentDto getSingleResturent(Integer resturentId);

    //Update DRIER
    ResturentDto updateResturent(ResturentDto resturentDto, Integer dresturentId);

    // Delete DRIER
    String deleteResturent(Integer resturentId);
}
