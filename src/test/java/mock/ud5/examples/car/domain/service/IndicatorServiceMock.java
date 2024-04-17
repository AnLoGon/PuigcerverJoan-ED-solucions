package mock.ud5.examples.car.domain.service;

import ud5.examples.car.domain.service.IndicatorService;

public class IndicatorServiceMock implements IndicatorService {
    private boolean showMaxSpeedIndicator = false;

    @Override
    public void showMaxSpeedIndicator(boolean showNotification) {
        showMaxSpeedIndicator = showNotification;
    }

    /**
     * Mètode del Mock per comprovar l'estat del mètode showMaxSpeedIndicator
     * @return true si s'ha cridat el mètode showMaxSpeedIndicator amb true, false en cas contrari
     */
    public boolean isMaxSpeedIndicatorShown() {
        return showMaxSpeedIndicator;
    }
}
