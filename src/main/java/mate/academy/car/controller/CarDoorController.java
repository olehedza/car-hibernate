package mate.academy.car.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.car.dto.request.CarDoorRequestDto;
import mate.academy.car.dto.response.CarDoorResponseDto;
import mate.academy.car.mapper.CarDoorMapper;
import mate.academy.car.model.CarDoor;
import mate.academy.car.service.CarDoorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doors")
@AllArgsConstructor
public class CarDoorController {
    private final CarDoorService doorService;
    private final CarDoorMapper doorMapper;

    @PostMapping
    public void createDoor(@RequestBody CarDoorRequestDto dto) {
        doorService.add(doorMapper.toModel(dto));
    }

    @GetMapping
    public List<CarDoorResponseDto> getAllDoors() {
        List<CarDoor> doors = doorService.getAll();
        return doors.stream()
                .map(doorMapper::toDto)
                .collect(Collectors.toList());
    }
}
