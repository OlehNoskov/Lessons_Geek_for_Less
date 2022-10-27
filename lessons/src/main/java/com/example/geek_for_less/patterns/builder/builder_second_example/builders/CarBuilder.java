package com.example.geek_for_less.patterns.builder.builder_second_example.builders;

import com.example.geek_for_less.patterns.builder.builder_second_example.cars.Car;
import com.example.geek_for_less.patterns.builder.builder_second_example.cars.CarType;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.Engine;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.GPSNavigator;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.Transmission;
import com.example.geek_for_less.patterns.builder.builder_second_example.components.TripComputer;

/**
 * Конкретные строители реализуют шаги, объявленные в общем интерфейсе.
 */

public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
