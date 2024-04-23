package unit.ud5.examples.car.domain.service.impl;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.IndicatorService;
import ud5.examples.car.domain.service.impl.CarServiceImpl;
import ud5.examples.car.exception.ResourceNotFoundException;
import ud5.examples.car.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceImplMockitoTest {
    // Es creen els objectes simulats
    @Mock
    private CarRepository carRepositoryMock;
    @Mock
    private IndicatorService indicatorServiceMock;

    // S'injecten els objectes simulats a la implementació
    @InjectMocks
    private CarServiceImpl carService;

    private final Car car1 = new Car("1234ABC", "Seat", "Ibiza");
    private final Car car2 = new Car("4321ABC", "Renault", "Clio");
    private final List<Car> cars = List.of(car1, car2);

    @Nested
    class FindAll {
        @Test
        void whenRepositoryReturnsEmptyList_shouldReturnEmptyList() {
            // Es configura el comportament del carRepositoryMock
            when(carRepositoryMock.findAll()).thenReturn(new ArrayList<>());

            // Internament es crida a carRepositoryMock.findAll()
            assertEquals(0, carService.findAll().size());
        }
        @Test
        void whenRepositoryReturnsCars_shouldReturnAllCars() {
            // Es configura el comportament del carRepositoryMock
            when(carRepositoryMock.findAll()).thenReturn(cars);

            // Internament es crida a carRepositoryMock.findAll()
            assertEquals(2, carService.findAll().size());
        }
    }

    @Nested
    class FindByPlate {
        @Test
        void givenExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            // Es configura el comportament del carRepositoryMock
            when(carRepositoryMock.findByPlate("1234ABC")).thenReturn(car1);

            // Internament es crida a carRepositoryMock.findByPlate("1234ABC")
            Car resultCar = carService.findByPlate("1234ABC");

            assertEquals(car1, resultCar);
        }

        @Test
        void givenDifferentExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            // Es configura el comportament del carRepositoryMock
            when(carRepositoryMock.findByPlate("4321ABC")).thenReturn(car2);

            // Internament es crida a carRepositoryMock.findByPlate("4321ABC")
            Car resultCar = carService.findByPlate("4321ABC");

            assertEquals(car2, resultCar);
        }

        @Test
        void givenNonExistingCarWithPlate_shouldThrowResourceNotFoundException() throws ResourceNotFoundException {
            // Es configura el comportament del carRepositoryMock
            when(carRepositoryMock.findByPlate("0000ZZZ")).thenThrow(ResourceNotFoundException.class);

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

            verify(indicatorServiceMock).showMaxSpeedIndicator(false);
        }

        @Test
        void givenAcceleratedCarGreaterThanMaximumSpeed_shouldShowMaxSpeedIndicator() {
            Car car = new Car("1234ABC", "Seat", "Ibiza");
            // Internament es crida a indicatorServiceMock.showMaxSpeedIndicator(true)
            carService.accelerate(car, 130.0);

            verify(indicatorServiceMock).showMaxSpeedIndicator(true);
        }
    }

    @Nested
    class InsertCar {
        @Test
        void shouldInsertCar() {
            Car car = new Car("1234ABC", "Seat", "Ibiza");
            carService.insertCar(car);

            verify(carRepositoryMock).insertCar(car);
        }
    }
}