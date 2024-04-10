package ud5.examples.car.domain.service;

import ud5.examples.car.domain.entity.Car;

public interface EmailService {
    void sendWorkshopWarning(Car car);
}
