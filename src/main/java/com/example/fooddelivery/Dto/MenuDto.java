package com.example.fooddelivery.Dto;

import com.example.fooddelivery.Model.Resturent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuDto {

    private Integer menuId;
    private String menuName;
    private Double price;
    private Resturent resturent;

}
