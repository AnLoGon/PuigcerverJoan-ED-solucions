package ud5.examples.car.repository;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.exception.ResourceNotFoundException;

import java.util.List;

public interface CarRepository {

    List<Car> findAll();
    Car findByPlate(String plate) throws ResourceNotFoundException;
}
