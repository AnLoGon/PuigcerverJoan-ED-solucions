package ud5.examples.car.domain.service.impl;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.EmailService;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.domain.service.CarService;
import ud5.examples.car.repository.CarRepository;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final EmailService emailService;

    public CarServiceImpl(CarRepository carRepository, EmailService emailService) {
        this.carRepository = carRepository;
        this.emailService = emailService;
    }

    @Override
    public Car getByPlate(String plate) throws ResourceNotFoundException {
        return carRepository.getByPlate(plate);
    }

    @Override
    public void updateKilometers(Car car) {
        carRepository.updateKilometers(car);
        if(car.getKilometers() > 100000)
            emailService.sendWorkshopWarning(car);
    }
}