package ru.sber.ws.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.sber.model.Car;
import ru.sber.model.CarPlace;

import java.util.List;

@RestController
public interface ReportController {

    List<CarPlace> getFreeCarPlaces();

    List<Car> getCarsOnParkingAll();

    List<Car> getCarsOnParkingNow();
}
