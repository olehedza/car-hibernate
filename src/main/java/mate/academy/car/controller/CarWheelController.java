package mate.academy.car.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.car.dto.request.CarWheelRequestDto;
import mate.academy.car.dto.response.CarWheelResponseDto;
import mate.academy.car.mapper.CarWheelMapper;
import mate.academy.car.model.CarWheel;
import mate.academy.car.service.CarWheelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wheels")
@AllArgsConstructor
public class CarWheelController {
    private final CarWheelService wheelService;
    private final CarWheelMapper wheelMapper;

    @PostMapping
    public void createWheel(@RequestBody CarWheelRequestDto dto) {
        wheelService.add(wheelMapper.toModel(dto));
    }

    @GetMapping
    public List<CarWheelResponseDto> getAllWheels() {
        List<CarWheel> wheels = wheelService.getAll();
        return wheels.stream()
                .map(wheelMapper::toDto)
                .collect(Collectors.toList());
    }
}
