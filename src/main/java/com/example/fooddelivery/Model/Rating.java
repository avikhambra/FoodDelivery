package com.example.fooddelivery.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private Integer rating;

    @ManyToOne
    @JoinColumn
    @JsonBackReference(value = "Xyz")
    private Users userId;

//    @OneToOne
    @ManyToOne
    @JsonBackReference
    private Resturent resturentId;
}
