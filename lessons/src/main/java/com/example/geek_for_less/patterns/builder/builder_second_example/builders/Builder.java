package com.example.geek_for_less.patterns.builder.builder_second_example.builders;

import com.example.geek_for_less.patterns.builder.builder_second_example.cars.CarType;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.Engine;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.GPSNavigator;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.Transmission;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.TripComputer;

/**
 * Интерфейс Строителя объявляет все возможные этапы и шаги конфигурации
 * продукта.
 */

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}