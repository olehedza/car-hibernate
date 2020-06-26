package mate.academy.car.service.impl;

import java.util.List;
import mate.academy.car.dao.CarDao;
import mate.academy.car.lib.Inject;
import mate.academy.car.lib.Service;
import mate.academy.car.model.Car;
import mate.academy.car.service.CarService;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    private CarDao carDao;

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car getById(Long id) {
        return carDao.getById(id).orElseThrow();
    }

    @Override
    public List<Car> getCarsByEngineType(String engineType) {
        return carDao.getCarsByEngineType(engineType);
    }
}
