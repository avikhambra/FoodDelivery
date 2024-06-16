package com.example.fooddelivery.Repositry;

import com.example.fooddelivery.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
}
