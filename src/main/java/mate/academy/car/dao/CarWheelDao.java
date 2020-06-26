package mate.academy.car.dao;

import java.util.List;
import mate.academy.car.model.CarWheel;

public interface CarWheelDao {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
