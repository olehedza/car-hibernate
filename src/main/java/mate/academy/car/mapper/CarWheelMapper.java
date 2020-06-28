package mate.academy.car.mapper;

import mate.academy.car.dto.request.CarWheelRequestDto;
import mate.academy.car.dto.response.CarWheelResponseDto;
import mate.academy.car.model.CarWheel;
import org.springframework.stereotype.Component;

@Component
public class CarWheelMapper {
    public CarWheel toModel(CarWheelRequestDto dto) {
        CarWheel model = new CarWheel();
        model.setTireIntegrity(dto.getTireIntegrity());
        return model;
    }

    public CarWheelResponseDto toDto(CarWheel model) {
        CarWheelResponseDto dto = new CarWheelResponseDto();
        dto.setId(model.getId());
        dto.setTireIntegrity(model.getTireIntegrity());
        return dto;
    }
}
