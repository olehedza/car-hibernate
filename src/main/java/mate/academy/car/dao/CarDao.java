package mate.academy.car.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.car.model.Car;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();

    Optional<Car> getById(Long id);

    List<Car> getCarsByEngineType(String engineType);
}
