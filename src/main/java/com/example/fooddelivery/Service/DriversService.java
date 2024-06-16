package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.DriversDto;
import com.example.fooddelivery.Dto.UsersDtos;

import java.util.List;

public interface DriversService {

    // ADD DRIVER
    DriversDto addDriver(DriversDto driversDto);

    // All DRIVER
    List<DriversDto> getAllDriver();

    // Single DRIER
    DriversDto getSingleDriver(Integer driverId);

    //Update DRIER
    DriversDto updateDriver(DriversDto driversDto, Integer driverId);

    // Delete DRIER
    String deleteDriver(Integer driverId);


}
