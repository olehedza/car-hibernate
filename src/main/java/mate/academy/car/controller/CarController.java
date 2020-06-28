package mate.academy.car.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.car.dto.request.CarRequestDto;
import mate.academy.car.dto.response.CarResponseDto;
import mate.academy.car.mapper.CarMapper;
import mate.academy.car.model.Car;
import mate.academy.car.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @PostMapping
    public void createCar(@RequestBody CarRequestDto dto) {
        carService.add(carMapper.toModel(dto));
    }

    @GetMapping
    public List<CarResponseDto> getAllCars() {
        List<Car> cars = carService.getAll();
        return cars.stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }
}
