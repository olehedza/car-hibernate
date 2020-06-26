package mate.academy.car.service;

import java.util.List;
import mate.academy.car.model.CarDoor;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
