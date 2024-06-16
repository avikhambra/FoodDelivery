package com.example.fooddelivery.Model;

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
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    private String menuName;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "resturentId")
    private Resturent resturent;
}
