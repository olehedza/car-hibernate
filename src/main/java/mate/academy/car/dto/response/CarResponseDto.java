package mate.academy.car.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarResponseDto {
    private Long id;
    private String dateOfManufacture;
    private String engineType;
    private double maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int currentCountOfPassengers;
    private double currentSpeed;
    private List<CarWheelResponseDto> wheels;
    private List<CarDoorResponseDto> doors;
}
