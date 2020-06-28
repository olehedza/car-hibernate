package mate.academy.car.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.car.dao.CarDoorDao;
import mate.academy.car.model.CarDoor;
import mate.academy.car.service.CarDoorService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarDoorServiceImpl implements CarDoorService {
    private final CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
