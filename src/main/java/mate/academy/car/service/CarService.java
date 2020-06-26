package mate.academy.car.service;

import java.util.List;
import mate.academy.car.model.Car;

public interface CarService {
    Car add(Car car);

    List<Car> getAll();

    Car getById(Long id);

    List<Car> getCarsByEngineType(String engineType);
}
