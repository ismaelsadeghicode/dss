package ir.mahdiyehrezaei.springcloudservicecar.controller;

import ir.mahdiyehrezaei.springcloudservicecar.domain.CarInfo;
import ir.mahdiyehrezaei.springcloudservicecar.dto.CarDto;
import ir.mahdiyehrezaei.springcloudservicecar.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping
    public ModelAndView showHelp(){
        return new ModelAndView("help.html");
    }

    @GetMapping("brand/{brand}/name/{name}/color/{color}")
    public CarDto getCarRequest(@PathVariable String brand,
                                @PathVariable String name,
                                @PathVariable String color){
        CarInfo carInfo = carRepository.findByBrandContainingAndNameContainingAndColorContaining(brand, name, color);
        ModelMapper modelMapper = new ModelMapper();
        CarDto carDto = modelMapper.map(carInfo, CarDto.class);
        return new CarDto()
                .setId(carDto.getId())
                .setBrand(brand)
                .setName(name)
                .setColor(color)
                .setPrice(carDto.getPrice())
                .setProductionYear(carDto.getProductionYear());
    }

    @GetMapping("list")
    public List<CarInfo> getAllCars(){
        return carRepository.findAll();
    }
}
