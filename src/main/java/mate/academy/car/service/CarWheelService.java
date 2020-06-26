package mate.academy.car.service;

import java.util.List;
import mate.academy.car.model.CarWheel;

public interface CarWheelService {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
