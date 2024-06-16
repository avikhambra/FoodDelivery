package com.example.fooddelivery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Resturent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resturentId;
    private String resturentName;
    private String resturentAddress;
    private String phoneNo;

    @OneToMany(mappedBy = "resturentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference
    private List<Rating> rating;

}
