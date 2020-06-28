package mate.academy.car.mapper;

import mate.academy.car.dto.request.CarDoorRequestDto;
import mate.academy.car.dto.response.CarDoorResponseDto;
import mate.academy.car.model.CarDoor;
import mate.academy.car.model.Mode;
import org.springframework.stereotype.Component;

@Component
public class CarDoorMapper {
    public CarDoor toModel(CarDoorRequestDto dto) {
        CarDoor model = new CarDoor();
        model.setDoorMode(Mode.valueOf(dto.getDoorMode()));
        model.setWindowMode(Mode.valueOf(dto.getWindowMode()));
        return model;
    }

    public CarDoorResponseDto toDto(CarDoor model) {
        CarDoorResponseDto dto = new CarDoorResponseDto();
        dto.setId(model.getId());
        dto.setDoorMode(model.getDoorMode().name());
        dto.setWindowMode(model.getWindowMode().name());
        return dto;
    }
}
