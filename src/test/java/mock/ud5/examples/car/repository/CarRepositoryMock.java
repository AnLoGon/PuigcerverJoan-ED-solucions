package mock.ud5.examples.car.repository;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryMock implements CarRepository {
    private List<Car> updatedKilometersCar = new ArrayList<>();

    @Override
    public Car getByPlate(String plate) throws ResourceNotFoundException {
        if (plate.equals("4321ABC")) {
            return new Car("4321ABC", "Renault", "Clio");
        } else if (plate.equals("1234ABC")) {
            return new Car("1234ABC", "Seat", "Ibiza");
        } else
            throw new ResourceNotFoundException("Car with plate " + plate + " not found");
    }

    @Override
    public void updateKilometers(Car car) {
        // Do nothing
        updatedKilometersCar.add(car);
    }

    public boolean verifyUpdateKilometers(Car car){
        return updatedKilometersCar.contains(car);
    }
}
