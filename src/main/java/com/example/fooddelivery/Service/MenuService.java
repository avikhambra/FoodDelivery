package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.MenuDto;

import java.util.List;

public interface MenuService {

    MenuDto createManu(MenuDto menuDto, Integer resturentId);

    // All Menu
    List<MenuDto> getAllMenu();

    // Single Menu
    MenuDto getSingleMenu(Integer menuId);

    //Update Menu
    MenuDto updateMenu(MenuDto menuDto, Integer menuId);

    // Delete Menu
    String deleteMenu(Integer menuId);
}
