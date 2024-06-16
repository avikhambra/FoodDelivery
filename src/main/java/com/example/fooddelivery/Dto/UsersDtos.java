package com.example.fooddelivery.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDtos {

    private Integer userId;
    private String name;

    @NotBlank
    private String phoneNumber;
    private String username;
    private String password;

    @Email
    private String email;



}
