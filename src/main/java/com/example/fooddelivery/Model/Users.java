package com.example.fooddelivery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;

    @NotBlank
    private String phoneNumber;
    private String username;
    private String password;
    @Email
    private String email;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonManagedReference(value = "Xyz")
    private List<Rating> rating;

}
