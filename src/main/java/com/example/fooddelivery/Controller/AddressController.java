package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.AddressDto;
import com.example.fooddelivery.Model.Address;
import com.example.fooddelivery.Service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    // Create address
    @PostMapping("/user/{userId}")
    private ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto, @PathVariable Integer userId){
        AddressDto addressDto1 = addressService.createAddress(addressDto, userId);
        return new ResponseEntity<>(addressDto1, HttpStatus.CREATED);
    }


    // All address
    @GetMapping("/allAddress")
    private ResponseEntity<List<AddressDto>> AllAddress(){
        List<AddressDto> addresses = addressService.getAllAddress();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    // Single address
    @GetMapping("/{addressId}")
    private ResponseEntity<AddressDto> getSingleAddress(@PathVariable Integer addressId){
        AddressDto addressDto = addressService.getSingleAddress(addressId);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    //Update address
    @PostMapping("/{addressId}")
    private ResponseEntity<AddressDto> updateAddress(
            @RequestBody AddressDto addressDto,
            @PathVariable Integer addressId){
        AddressDto addressDto1 = addressService.updateAddress(addressDto,addressId);
        return new ResponseEntity<>(addressDto1, HttpStatus.OK);
    }

    // Delete address
    @DeleteMapping("/{addressId}")
    private ResponseEntity<String> deleteAddress(@PathVariable Integer addressId){
        addressService.deleteAddress(addressId);
        return new ResponseEntity<>("Address Deleted", HttpStatus.OK);
    }

}
