package ru.sber.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sber.db.dao.ReportDAO;
import ru.sber.db.dao.ReportMapper;
import ru.sber.model.Car;
import ru.sber.model.CarPlace;

import java.util.List;

@RequestMapping("/report")
public class ReportControllerImpl implements ReportController {

    @Autowired
    private ReportDAO reportDAO;

    @RequestMapping("/getFreeCarPlaces")
    @Override
    public List<CarPlace> getFreeCarPlaces() {
        return reportDAO.getFreeCarPlaces();
    }

    @RequestMapping("/getCarsOnParkingAll")
    @Override
    public List<Car> getCarsOnParkingAll() {
        return reportDAO.getCarsOnParkingAll();
    }

    @RequestMapping("/getCarsOnParkingNow")
    @Override
    public List<Car> getCarsOnParkingNow() {
        return reportDAO.getCarsOnParkingNow();
    }
}
