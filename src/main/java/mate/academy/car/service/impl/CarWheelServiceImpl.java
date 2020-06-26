package mate.academy.car.service.impl;

import java.util.List;
import mate.academy.car.dao.CarWheelDao;
import mate.academy.car.lib.Inject;
import mate.academy.car.lib.Service;
import mate.academy.car.model.CarWheel;
import mate.academy.car.service.CarWheelService;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Inject
    private CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
