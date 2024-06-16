package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.ResturentDto;
import com.example.fooddelivery.Service.ResturentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/resturent")
public class RestruentController {

    private ResturentService resturentService;

    @PostMapping
    public ResponseEntity<ResturentDto> addResturent(@RequestBody ResturentDto resturentDto) {
        ResturentDto resturentDto1 = resturentService.addResturent(resturentDto);
        return new ResponseEntity<>(resturentDto1, HttpStatus.CREATED);
    }

    // Single resturentId
    @GetMapping("/{resturentId}")
    ResponseEntity<ResturentDto> SingleResturent(@PathVariable Integer resturentId){
        ResturentDto resturentDto = resturentService.getSingleResturent(resturentId);
        return new ResponseEntity<>(resturentDto, HttpStatus.OK);
    }

    // All DRIVER
    @GetMapping("/allResturent")
    ResponseEntity<List<ResturentDto>> AllResturent(){
        List<ResturentDto> resturentDtos = resturentService.getAllResturent();
        return new ResponseEntity<>(resturentDtos, HttpStatus.OK);
    }
    //Update resturent
    @PostMapping("/{resturentId}")
    ResponseEntity<ResturentDto> updateResturent(@RequestBody ResturentDto resturentDto,
                                 @PathVariable Integer resturentId){
        ResturentDto resturentDto1 = resturentService.updateResturent(resturentDto, resturentId);
        return new ResponseEntity<>(resturentDto1, HttpStatus.CREATED);
    };

    // Delete resturent
    @DeleteMapping("/{resturentId}")
    ResponseEntity<String> deleteResturent(@PathVariable Integer resturentId){
        resturentService.deleteResturent(resturentId);
        return new ResponseEntity<>("resturent Deleted ",HttpStatus.NO_CONTENT);
    };
}
