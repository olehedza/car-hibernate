package mate.academy.car.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.car.dao.CarWheelDao;
import mate.academy.car.model.CarWheel;
import mate.academy.car.service.CarWheelService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarWheelServiceImpl implements CarWheelService {
    private final CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
