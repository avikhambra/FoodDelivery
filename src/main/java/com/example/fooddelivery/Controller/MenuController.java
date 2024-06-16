package com.example.fooddelivery.Controller;

import com.example.fooddelivery.Dto.MenuDto;
import com.example.fooddelivery.Service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    @PostMapping("/resturent/{resturentId}")
    public ResponseEntity<MenuDto> createMenu(
            @RequestBody MenuDto menuDto,
            @PathVariable Integer resturentId){

        MenuDto menuDto1 = menuService.createManu(menuDto, resturentId);
        return new ResponseEntity<>(menuDto1, HttpStatus.CREATED);
    }


    // All Menu
    @GetMapping("/allMenu")
    ResponseEntity<List<MenuDto>> AllMenu(){
        List<MenuDto> menuDtos = menuService.getAllMenu();
        return new ResponseEntity<>(menuDtos, HttpStatus.OK);
    };

    // Single Menu
    @GetMapping("/{menuId}")
    ResponseEntity<MenuDto> SingleMenu(@PathVariable Integer menuId){
        MenuDto menuDto = menuService.getSingleMenu(menuId);
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    };


    //Update Menu
    @PostMapping("/{menuId}")
    ResponseEntity<MenuDto> updateMenu(
            @RequestBody MenuDto menuDto,
            @PathVariable Integer menuId){
        MenuDto menuDto1 = menuService.updateMenu(menuDto,menuId);
        return new ResponseEntity<>(menuDto1, HttpStatus.OK);
    };

    // Delete Menu
    @DeleteMapping("/{menuId}")
    ResponseEntity<String> deleteMenu(@PathVariable Integer menuId){
        menuService.deleteMenu(menuId);
        return new ResponseEntity<>("Menu deleted", HttpStatus.OK);
    };

}
