package mock.ud5.examples.car.domain.service;

import ud5.examples.car.domain.entity.Car;
import ud5.examples.car.domain.service.EmailService;

import java.util.ArrayList;
import java.util.List;

public class EmailServiceMock implements EmailService {

    private final List<Car> sentWorshopWarnings = new ArrayList<>();
    @Override
    public void sendWorkshopWarning(Car car) {
        sentWorshopWarnings.add(car);
    }

    public boolean verifySendWorkshopWarning(Car car){
        return sentWorshopWarnings.contains(car);
    }
}
