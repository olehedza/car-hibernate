package mate.academy.car.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import mate.academy.car.dto.request.CarRequestDto;
import mate.academy.car.dto.response.CarResponseDto;
import mate.academy.car.model.Car;
import mate.academy.car.model.CarDoor;
import mate.academy.car.model.CarWheel;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarMapper {
    private final CarWheelMapper carWheelMapper;
    private final CarDoorMapper carDoorMapper;

    public Car toModel(CarRequestDto dto) {
        Car model = new Car();
        model.setDateOfManufacture(
                LocalDate.parse(dto.getDateOfManufacture(),
                        DateTimeFormatter.ofPattern("yyyy:MM:dd"))
        );
        model.setMaxSpeed(dto.getMaxSpeed());
        model.setCurrentSpeed(dto.getCurrentSpeed());
        model.setEngineType(dto.getEngineType());
        model.setPassengerCapacity(dto.getPassengerCapacity());
        model.setCurrentCountOfPassengers(dto.getCurrentCountOfPassengers());
        model.setAccelerationTime(dto.getAccelerationTime());
        model.setDoors(
                IntStream.range(0, dto.getDoors())
                        .mapToObj(i -> new CarDoor())
                        .collect(Collectors.toList())
        );
        model.setWheels(
                IntStream.range(0, dto.getWheels())
                        .mapToObj(i -> new CarWheel())
                        .collect(Collectors.toList())
        );
        return model;
    }

    public CarResponseDto toDto(Car model) {
        CarResponseDto dto = new CarResponseDto();
        dto.setId(model.getId());
        dto.setEngineType(model.getEngineType());
        dto.setAccelerationTime(model.getAccelerationTime());
        dto.setCurrentSpeed(model.getCurrentSpeed());
        dto.setMaxSpeed(model.getMaxSpeed());
        dto.setCurrentCountOfPassengers(model.getCurrentCountOfPassengers());
        dto.setDateOfManufacture(model.getDateOfManufacture().toString());
        dto.setDoors(
                model.getDoors().stream()
                        .map(carDoorMapper::toDto)
                        .collect(Collectors.toList())
        );
        dto.setWheels(
                model.getWheels().stream()
                        .map(carWheelMapper::toDto)
                        .collect(Collectors.toList())
        );
        return dto;
    }
}
