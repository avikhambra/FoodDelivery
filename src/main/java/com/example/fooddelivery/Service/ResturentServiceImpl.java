package com.example.fooddelivery.Service;

import com.example.fooddelivery.Dto.ResturentDto;
import com.example.fooddelivery.Model.Rating;
import com.example.fooddelivery.Model.Resturent;
import com.example.fooddelivery.Repositry.RatingRepo;
import com.example.fooddelivery.Repositry.ResturentRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResturentServiceImpl implements ResturentService{

    private ModelMapper modelMapper;
    private ResturentRepo resturentRepo;
    private RatingRepo ratingRepo;

    @Override
    public ResturentDto addResturent(ResturentDto resturentDto) {
        Resturent resturent = DtoToResturent(resturentDto);
        Resturent resturent1 = resturentRepo.save(resturent);
        return resturentToDto(resturent1);
    }

    @Override
    public List<ResturentDto> getAllResturent() {
        List<Resturent> resturents = resturentRepo.findAll();
        return resturents.stream().map( res -> resturentToDto(res)).collect(Collectors.toList());
    }

    @Override
    public ResturentDto getSingleResturent(Integer resturentId) {
        Resturent resturent = resturentRepo.findById(resturentId).get();
        return resturentToDto(resturent);
    }

    @Override
    public ResturentDto updateResturent(ResturentDto resturentDto, Integer resturentId) {
        Resturent resturent = resturentRepo.findById(resturentId).get();

        resturent.setResturentName(resturentDto.getResturentName());
        resturent.setResturentAddress(resturentDto.getResturentAddress());
        resturent.setPhoneNo(resturentDto.getPhoneNo());
        Resturent resturent1 = resturentRepo.save(resturent);

        return resturentToDto(resturent1);
    }

    @Override
    public String deleteResturent(Integer resturentId) {
        resturentRepo.deleteById(resturentId);
        return "";
    }




    // Model Mapper
    public Resturent DtoToResturent(ResturentDto resturentDto){
        return modelMapper.map(resturentDto, Resturent.class);
    }
   public ResturentDto resturentToDto(Resturent resturent){
        return modelMapper.map(resturent, ResturentDto.class);
    }
}
