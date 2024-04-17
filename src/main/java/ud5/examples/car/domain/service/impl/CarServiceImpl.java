package ud5.examples.car.domain.service.impl;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.IndicatorService;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.domain.service.CarService;
import ud5.examples.car.repository.CarRepository;

import java.util.List;

public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final IndicatorService indicatorService;


    public CarServiceImpl(CarRepository carRepository, IndicatorService indicatorService) {
        this.carRepository = carRepository;
        this.indicatorService = indicatorService;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }
    
    @Override
    public Car findByPlate(String plate) throws ResourceNotFoundException {
        return carRepository.findByPlate(plate);
    }

    @Override
    public void accelerate(Car car, double speed) {
        car.accelerate(speed);
        indicatorService.showMaxSpeedIndicator(car.getSpeed() > 120);
    }
}