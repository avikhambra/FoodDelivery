package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.MenuDto;
import com.example.fooddelivery.Model.Menu;
import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Repositry.MenuRepo;
import com.example.fooddelivery.Repositry.ResturentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private ModelMapper modelMapper;
    private MenuRepo menuRepo;
    private ResturentRepo resturentRepo;

    @Override
    public MenuDto createManu(MenuDto menuDto, Integer resturentId) {

        Resturent resturent = resturentRepo.findById(resturentId).orElseThrow(()-> new RuntimeException("Resturnt is close"));

        Menu menu = DtoToMenu(menuDto);
        menu.setResturent(resturent);
        Menu menu1 = menuRepo.save(menu);

        return MenuToDto(menu1);
    }

    @Override
    public List<MenuDto> getAllMenu() {
        List<Menu> menus = menuRepo.findAll();
        return menus.stream().map( menu->MenuToDto(menu)).collect(Collectors.toList());
    }

    @Override
    public MenuDto getSingleMenu(Integer menuId) {
        Menu menu = menuRepo.findById(menuId).get();
        return MenuToDto(menu);
    }

    @Override
    public MenuDto updateMenu(MenuDto menuDto, Integer menuId) {
        Menu menu = menuRepo.findById(menuId).get();

        menu.setMenuName(menuDto.getMenuName());
        menu.setPrice(menuDto.getPrice());
        Menu menu1 = menuRepo.save(menu);

        return MenuToDto(menu1);
    }

    @Override
    public String deleteMenu(Integer menuId) {
        menuRepo.deleteById(menuId);
        return "";
    }


    // ModelMapper
    MenuDto MenuToDto(Menu menu){
        return modelMapper.map(menu, MenuDto.class);
    }
    Menu DtoToMenu(MenuDto menuDto){
        return modelMapper.map(menuDto, Menu.class);
    }
}
