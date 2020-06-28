package mate.academy.car;

import java.time.LocalDate;
import java.util.List;
import mate.academy.car.config.AppConfig;
import mate.academy.car.model.Car;
import mate.academy.car.model.CarDoor;
import mate.academy.car.model.CarWheel;
import mate.academy.car.model.Mode;
import mate.academy.car.service.CarDoorService;
import mate.academy.car.service.CarService;
import mate.academy.car.service.CarWheelService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    private static final CarService carService =
            context.getBean(CarService.class);
    private static final CarDoorService carDoorService =
            context.getBean(CarDoorService.class);
    private static final CarWheelService carWheelService =
            context.getBean(CarWheelService.class);

    public static void main(String[] args) {
        Car car = new Car();
        car.setAccelerationTime(8);
        car.setPassengerCapacity(4);
        car.setCurrentCountOfPassengers(2);
        car.setMaxSpeed(250);
        car.setCurrentSpeed(100);
        car.setDateOfManufacture(LocalDate.now());
        car.setEngineType("flat");

        CarDoor carDoor1 = new CarDoor();
        carDoor1.setDoorMode(Mode.CLOSED);
        carDoor1.setWindowMode(Mode.OPEN);
        carDoorService.add(carDoor1);
        CarDoor carDoor2 = new CarDoor();
        carDoor2.setDoorMode(Mode.OPEN);
        carDoor2.setWindowMode(Mode.OPEN);
        carDoorService.add(carDoor2);
        CarDoor carDoor3 = new CarDoor();
        carDoor3.setDoorMode(Mode.CLOSED);
        carDoor3.setWindowMode(Mode.OPEN);
        carDoorService.add(carDoor3);
        CarDoor carDoor4 = new CarDoor();
        carDoor4.setDoorMode(Mode.CLOSED);
        carDoor4.setWindowMode(Mode.OPEN);
        carDoorService.add(carDoor4);

        CarWheel carWheel1 = new CarWheel();
        carWheel1.setTireIntegrity(1.);
        carWheelService.add(carWheel1);
        CarWheel carWheel2 = new CarWheel();
        carWheel2.setTireIntegrity(0.8);
        carWheelService.add(carWheel2);
        CarWheel carWheel3 = new CarWheel();
        carWheel3.setTireIntegrity(1.);
        carWheelService.add(carWheel3);
        CarWheel carWheel4 = new CarWheel();
        carWheel4.setTireIntegrity(1.);
        carWheelService.add(carWheel4);

        List<CarDoor> carDoors = carDoorService.getAll();
        List<CarWheel> carWheels = carWheelService.getAll();
        car.setDoors(carDoors);
        car.setWheels(carWheels);
        carService.add(car);
    }
}
