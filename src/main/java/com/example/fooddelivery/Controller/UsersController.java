package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.UsersDtos;
import com.example.fooddelivery.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UsersController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UsersDtos> createUsers(@RequestBody UsersDtos usersDtos){
        UsersDtos usersDtos1 = userService.createUser(usersDtos);
        return new ResponseEntity<>(usersDtos1, HttpStatus.CREATED);
    }

    @GetMapping("/allUser")
    private ResponseEntity<List<UsersDtos>> getAllusers(){
        List<UsersDtos> usersDtos = userService.getAllUser();
        return new ResponseEntity<List<UsersDtos>>(usersDtos, HttpStatus.OK);
    }

    // GET SINGLE USER
    @GetMapping("/{userId}")
    private ResponseEntity<UsersDtos> getSingleUser(@PathVariable Integer userId){
        UsersDtos usersDtos = userService.getSingleUser(userId);
        return new ResponseEntity<>(usersDtos, HttpStatus.OK);
    }

    // UPDATE USER
    @PostMapping("/update/{userId}")
    private ResponseEntity<UsersDtos> updateSingleUser(
            @RequestBody UsersDtos usersDtos,
            @PathVariable Integer userId){

        UsersDtos usersDtos1 = userService.updateUser(usersDtos,userId);
        return new ResponseEntity<>(usersDtos1, HttpStatus.OK);
    }


    // DELETE USER BY ID
    @DeleteMapping("/{userId}")
    private ResponseEntity<String> deleteSingleUser(@PathVariable Integer userId){
      userService.deleteUser(userId);
      return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }
}
