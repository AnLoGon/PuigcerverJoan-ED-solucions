package ud5.examples.car.domain.service;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.exception.ResourceNotFoundException;

public interface CarService {
    Car getByPlate(String plate) throws ResourceNotFoundException;

    void updateKilometers(Car car);
}
