package unit.ud5.examples.car.domain.service.impl;

import mock.ud5.examples.car.domain.service.IndicatorServiceMock;
import mock.ud5.examples.car.repository.CarRepositoryMock;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.CarService;
import ud5.examples.car.domain.service.impl.CarServiceImpl;
import ud5.examples.car.exception.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplManualTest {
    // Es creen els objectes simulats
    private final CarRepositoryMock carRepositoryMock = new CarRepositoryMock();
    private final IndicatorServiceMock indicatorServiceMock = new IndicatorServiceMock();
    // S'injecten els objectes simulats a la implementació
    private final CarService carService = new CarServiceImpl(carRepositoryMock, indicatorServiceMock);

    @Nested
    class FindAll {
        @Test
        void shouldReturnAllCars() {
            // Internament es crida a carRepositoryMock.findAll()
            assertEquals(2, carService.findAll().size());
        }
    }

    @Nested
    class FindByPlate {
        @Test
        void givenExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            // Internament es crida a carRepositoryMock.findByPlate("1234ABC")
            Car car = carService.findByPlate("1234ABC");

            assertAll(
                () -> assertNotNull(car),
                () -> assertEquals("1234ABC", car.getPlate()),
                () -> assertEquals("Seat", car.getBrand()),
                () -> assertEquals("Ibiza", car.getModel())
            );
        }

        @Test
        void givenDifferentExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            // Internament es crida a carRepositoryMock.findByPlate("4321ABC")
            Car car = carService.findByPlate("4321ABC");

            assertAll(
                    () -> assertNotNull(car),
                    () -> assertEquals("4321ABC", car.getPlate()),
                    () -> assertEquals("Renault", car.getBrand()),
                    () -> assertEquals("Clio", car.getModel())
            );
        }

        @Test
        void givenNonExistingCarWithPlate_shouldThrowResourceNotFoundException() {
            // Internament es crida a carRepositoryMock.findByPlate("0000ZZZ")
            assertThrows(ResourceNotFoundException.class, () -> carService.findByPlate("0000ZZZ"));
        }
    }

    @Nested
    class Accelerate {
        @Test
        void shouldAccelerateCar() {
            Car car = new Car("1234ABC", "Seat", "Ibiza");
            carService.accelerate(car, 10.0);

            assertEquals(10.0, car.getSpeed());
        }

        @Test
        void givenAcceleratedCarLessThanMaximumSpeed_shouldNotShowMaxSpeedIndicator() {
            Car car = new Car("1234ABC", "Seat", "Ibiza");
            // Internament es crida a indicatorServiceMock.showMaxSpeedIndicator(false)
            carService.accelerate(car, 10.0);

            assertFalse(indicatorServiceMock.isMaxSpeedIndicatorShown());
        }

        @Test
        void givenAcceleratedCarGreaterThanMaximumSpeed_shouldShowMaxSpeedIndicator() {
            Car car = new Car("1234ABC", "Seat", "Ibiza");
            // Internament es crida a indicatorServiceMock.showMaxSpeedIndicator(true)
            carService.accelerate(car, 130.0);

            assertTrue(indicatorServiceMock.isMaxSpeedIndicatorShown());
        }
    }
}