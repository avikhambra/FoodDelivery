package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.DriversDto;
import com.example.fooddelivery.Service.DriversService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/driver" )
public class DriversControllers {

    private DriversService driversService;

    @PostMapping()
    public ResponseEntity<DriversDto> addDrivers(@RequestBody DriversDto driversDto){
        DriversDto driversDto1 = driversService.addDriver(driversDto);
        return new ResponseEntity<>(driversDto1 , HttpStatus.CREATED);
    }

    // All DRIVER
    @GetMapping("/driversList")
    ResponseEntity<List<DriversDto>> AllDriverList(){
        List<DriversDto> driversDtos = driversService.getAllDriver();
        return new ResponseEntity<>(driversDtos , HttpStatus.OK);
    }

    // Single DRIER
    @GetMapping("/{driverId}")
    ResponseEntity<DriversDto> getSingleDriver(@PathVariable Integer driverId){
        DriversDto driversDto = driversService.getSingleDriver(driverId);
        return new ResponseEntity<>(driversDto , HttpStatus.OK);
    }

    //Update DRIER
    @PostMapping("/{driverId}")
    ResponseEntity<DriversDto> updateDriver(@RequestBody DriversDto driversDto, @PathVariable Integer driverId){
        DriversDto driversDto1 = driversService.updateDriver(driversDto, driverId);
        return new ResponseEntity<>(driversDto1, HttpStatus.OK);
    }

    // Delete DRIER
    @DeleteMapping("/{driverId}")
    ResponseEntity<String> deleteDriver(@PathVariable Integer driverId){
        driversService.deleteDriver(driverId);
        return new ResponseEntity<>("Driver deleted", HttpStatus.OK);
    }

}
