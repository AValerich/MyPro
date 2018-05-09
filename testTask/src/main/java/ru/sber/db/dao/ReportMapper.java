package ru.sber.db.dao;

import java.util.Map;

public interface ReportMapper {

    void getFreeCarPlaces(Map<String, Object> parameter);

    void getCarsOnParkingAll(Map<String, Object> parameter);

    void getCarsOnParkingNow(Map<String, Object> parameter);
}
