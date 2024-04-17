package mock.ud5.examples.car.repository;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.repository.CarRepository;

import java.util.List;

public class CarRepositoryMock implements CarRepository {
    private final List<Car> cars = List.of(
        new Car("1234ABC", "Seat", "Ibiza"),
        new Car("4321ABC", "Renault", "Clio")
    );

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findByPlate(String plate) throws ResourceNotFoundException {
        if (plate.equals("1234ABC")) {
            return cars.get(0);
        } else if (plate.equals("4321ABC")) {
            return cars.get(1);
        } else
            throw new ResourceNotFoundException("Car with plate " + plate + " not found");
    }
}
