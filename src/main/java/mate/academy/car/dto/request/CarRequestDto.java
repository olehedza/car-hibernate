package mate.academy.car.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CarRequestDto {
    private String dateOfManufacture;
    private String engineType;
    private double maxSpeed;
    private int accelerationTime;
    private int passengerCapacity;
    private int currentCountOfPassengers;
    private double currentSpeed;
    private short wheels;
    private short doors;
}
