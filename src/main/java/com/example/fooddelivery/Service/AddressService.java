package com.example.fooddelivery.Service;


import com.example.fooddelivery.Dto.AddressDto;
import com.example.fooddelivery.Dto.UsersDtos;

import java.util.List;

public interface AddressService {

    // Create
    AddressDto createAddress(AddressDto addressDto, Integer userId) ;

    // All address
    List<AddressDto> getAllAddress();

    // Single address
    AddressDto getSingleAddress(Integer addressId);

    //Update address
    AddressDto updateAddress(AddressDto addressDto, Integer addressId);

    // Delete address
    String deleteAddress(Integer addressId);
}
