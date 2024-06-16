package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.UsersDtos;
import com.example.fooddelivery.Model.Users;
import com.example.fooddelivery.Repositry.UsersRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UsersServiceImpl implements UserService {

    private UsersRepo usersRepo;
    private ModelMapper modelMapper;

    // Creaate User
    public UsersDtos createUser(UsersDtos usersDtos){
        Users users = DtoToUsers(usersDtos);
        Users users1 = usersRepo.save(users);
        return usersToDto(users);
    }

    // Get all Users
    @Override
    public List<UsersDtos> getAllUser() {
        List<Users> users = usersRepo.findAll();
        List<UsersDtos> usersDtos = users.stream().map( user -> usersToDto(user)).collect(Collectors.toList());
        return usersDtos;
    }

    // SINGLE USER
    @Override
    public UsersDtos getSingleUser(Integer userId) {
        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not FOUND"));
        return usersToDto(users);
    }

    // UPDATE USER
    @Override
    public UsersDtos updateUser(UsersDtos usersDtos, Integer userId) {
        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not FOUND"));

        users.setName(usersDtos.getName());
        users.setUsername(usersDtos.getUsername());
        users.setPassword(usersDtos.getPassword());
        users.setPhoneNumber(usersDtos.getPhoneNumber());
        users.setEmail(usersDtos.getEmail());
        Users users1 = usersRepo.save(users);
        UsersDtos usersDtos1 = usersToDto(users1);

        return usersDtos1;
    }

    // DELETE USER
    @Override
    public String deleteUser(Integer userId) {
        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not FOUND"));
        usersRepo.delete(users);
        return "USER DELETED SUCCESSFULLY";
    }




    // Model Mapper
    public Users DtoToUsers(UsersDtos usersDtos){
        Users users = modelMapper.map(usersDtos, Users.class);
        return users;
    }
    public UsersDtos usersToDto(Users users){
        UsersDtos usersDtos = modelMapper.map(users, UsersDtos.class);
        return usersDtos;
    }
}
