package ud5.examples.car.domain.service;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.exception.ResourceNotFoundException;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findByPlate(String plate) throws ResourceNotFoundException;
    void accelerate(Car car, double speed);

    void insertCar(Car car);
}
