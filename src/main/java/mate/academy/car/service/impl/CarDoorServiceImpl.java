package mate.academy.car.service.impl;

import java.util.List;
import mate.academy.car.dao.CarDoorDao;
import mate.academy.car.lib.Inject;
import mate.academy.car.lib.Service;
import mate.academy.car.model.CarDoor;
import mate.academy.car.service.CarDoorService;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Inject
    private CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
