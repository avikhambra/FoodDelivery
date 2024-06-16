package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.AddressDto;
import com.example.fooddelivery.Dto.UsersDtos;
import com.example.fooddelivery.Model.Address;
import com.example.fooddelivery.Model.Users;
import com.example.fooddelivery.Repositry.AddressRepo;
import com.example.fooddelivery.Repositry.UsersRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private UsersRepo usersRepo;
    private AddressRepo addressRepo;
    private ModelMapper modelMapper;

    public AddressDto createAddress(AddressDto addressDto, Integer userId){

        Users users = usersRepo.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found"));

        Address address = DtoToAddress(addressDto);
        address.setUsers(users);
        Address address1 = addressRepo.save(address);
        return AddressToDto(address1);
    }

    @Override
    public List<AddressDto> getAllAddress() {
        List<Address> addresses = addressRepo.findAll();
        List<AddressDto> addressDtos = addresses.stream().map( address -> AddressToDto(address)).collect(Collectors.toList());
        return addressDtos;
    }

    @Override
    public AddressDto getSingleAddress(Integer addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(()-> new RuntimeException("Address Not FOUND"));
        return AddressToDto(address);
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, Integer addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(()-> new RuntimeException("Address Not FOUND"));
//        Users users = usersRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        address.setAddress(addressDto.getAddress());
        address.setZip(addressDto.getZip());
        address.setCity(address.getCity());
//        address.setUsers(users);
        Address address1 = addressRepo.save(address);

        return AddressToDto(address1);
    }

    @Override
    public String deleteAddress(Integer addressId) {
        Address address = addressRepo.findById(addressId).orElseThrow(()-> new RuntimeException("Address Not FOUND for DELETE"));
        return "";
    }


    // Model Mapper
    public Address DtoToAddress(AddressDto addressDto){
        Address address = modelMapper.map(addressDto, Address.class);
        return address;
    }
    public AddressDto AddressToDto(Address address){
        AddressDto addressDto = modelMapper.map(address , AddressDto.class);
        return addressDto;
    }
}
