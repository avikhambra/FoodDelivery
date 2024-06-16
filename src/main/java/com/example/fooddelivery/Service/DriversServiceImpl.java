package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.DriversDto;
import com.example.fooddelivery.Model.Drivers;
import com.example.fooddelivery.Repositry.DriversRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DriversServiceImpl implements DriversService {

    private DriversRepo driversRepo;
    private ModelMapper modelMapper;

    @Override
    public DriversDto addDriver(DriversDto driversDto) {
        Drivers drivers = DtoToDriver(driversDto);
        Drivers drivers1 = driversRepo.save(drivers);
        return driverToDto(drivers1);
    }

    @Override
    public List<DriversDto> getAllDriver() {
        List<Drivers> drivers = driversRepo.findAll();
        List<DriversDto> driversDtos = drivers.stream().map( driver -> driverToDto(driver)).collect(Collectors.toList());
        return driversDtos;
    }

    @Override
    public DriversDto getSingleDriver(Integer driverId) {
        Drivers drivers = driversRepo.findById(driverId).get();
        return driverToDto(drivers);
    }

    @Override
    public DriversDto updateDriver(DriversDto driversDto, Integer driverId) {
        Drivers drivers = driversRepo.findById(driverId).get();

        drivers.setName(driversDto.getName());
        drivers.setContactNo(driversDto.getContactNo());

        Drivers drivers1 = driversRepo.save(drivers);
        return driverToDto(drivers1);
    }

    @Override
    public String deleteDriver(Integer driverId) {
        Drivers drivers = driversRepo.findById(driverId).get();
        driversRepo.delete(drivers);
        return "";
    }


    // Model Mapper
    public Drivers DtoToDriver(DriversDto driversDto){
        return modelMapper.map(driversDto, Drivers.class);
    }
    public DriversDto driverToDto(Drivers drivers){
        return modelMapper.map(drivers, DriversDto.class);
    }
}
