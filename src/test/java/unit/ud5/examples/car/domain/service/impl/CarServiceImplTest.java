package unit.ud5.examples.car.domain.service.impl;

import mock.ud5.examples.car.domain.service.EmailServiceMock;
import mock.ud5.examples.car.repository.CarRepositoryMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.CarService;
import ud5.examples.car.domain.service.impl.CarServiceImpl;
import ud5.examples.car.exception.ResourceNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {

    private final CarRepositoryMock carRepositoryMock = new CarRepositoryMock();
    private final EmailServiceMock emailServiceMock = new EmailServiceMock();
    private final CarService carService = new CarServiceImpl(carRepositoryMock, emailServiceMock);
    @Nested
    class GetByPlate {
        @Test
        void givenExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            Car car = carService.getByPlate("1234ABC");

            assertAll(
                () -> assertNotNull(car),
                () -> assertEquals("1234ABC", car.getPlate()),
                () -> assertEquals("Seat", car.getBrand()),
                () -> assertEquals("Ibiza", car.getModel())
            );
        }

        @Test
        void givenDifferentExistingCarWithPlate_shouldReturnCar() throws ResourceNotFoundException {
            Car car = carService.getByPlate("4321ABC");

            assertAll(
                    () -> assertNotNull(car),
                    () -> assertEquals("4321ABC", car.getPlate()),
                    () -> assertEquals("Renault", car.getBrand()),
                    () -> assertEquals("Clio", car.getModel())
            );
        }

        @Test
        void givenNonExistingCarWithPlate_shouldThrowResourceNotFoundException() {
            assertThrows(ResourceNotFoundException.class, () -> carService.getByPlate("0000ZZZ"));
        }
    }

    @Nested
    class UpdateKilometers {
        private Car car;

        @BeforeEach
        void setup() {
            car = new Car("1234ABC", "Seat", "Ibiza", 100);
        }

        @Test
        void givenExistingCar_shouldUpdateKilometers(){
            carService.updateKilometers(car);

            assertTrue(carRepositoryMock.verifyUpdateKilometers(car));
        }

        @Test
        void givenCarMoreThan100000Km_shouldSendEmail(){
            car.setKm(200000);
            carService.updateKilometers(car);
            assertTrue(emailServiceMock.verifySendWorkshopWarning(car));
        }

        @Test
        void givenCarLessThan100000Km_shouldNotSendEmail(){
            carService.updateKilometers(car);
            assertFalse(emailServiceMock.verifySendWorkshopWarning(car));
        }
    }

}