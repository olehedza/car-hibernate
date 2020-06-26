package mate.academy.car.dao;

import java.util.List;
import mate.academy.car.model.CarDoor;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
