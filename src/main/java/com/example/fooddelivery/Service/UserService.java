package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.UsersDtos;

import java.util.List;

public interface UserService {


    UsersDtos createUser(UsersDtos usersDtos);
// All user
    List<UsersDtos> getAllUser();

    // Single user
    UsersDtos getSingleUser(Integer userId);

    //Update User
    UsersDtos updateUser(UsersDtos usersDtos, Integer userId);

    // Delete User
    String deleteUser(Integer userId);

}
