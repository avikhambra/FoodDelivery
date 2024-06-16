package com.example.fooddelivery.Repositry;

import com.example.fooddelivery.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu, Integer> {
}
