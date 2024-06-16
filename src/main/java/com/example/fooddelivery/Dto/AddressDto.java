package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {
    private Integer addressId;
    private String address;
    private String city;
    private String zip;

    private Users users;
}
