package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResturentDto {

    private Integer resturentId;
    private String resturentName;
    private String resturentAddress;
    private String phoneNo;

}
