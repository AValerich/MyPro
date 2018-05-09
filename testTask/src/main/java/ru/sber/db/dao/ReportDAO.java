package ru.sber.db.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import ru.sber.model.Car;
import ru.sber.model.CarPlace;
import ru.sber.ws.controller.ReportController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.sber.ws.Constants.*;

@Component
public class ReportDAO extends MyBatisDAO<ReportMapper> implements ReportController {

    @Override
    public ReportMapper getMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(ReportMapper.class);
    }


    @Override
    public List<CarPlace> getFreeCarPlaces() {
        List<CarPlace> carPlaces;
        SqlSession sqlSession = getSqlSession();
        try {
            ReportMapper reportMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            reportMapper.getFreeCarPlaces(parameters);
            carPlaces = (List<CarPlace>) parameters.get(CAR_PLACES);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return carPlaces;
    }

    @Override
    public List<Car> getCarsOnParkingAll() {
        List<Car> cars;
        SqlSession sqlSession = getSqlSession();
        try {
            ReportMapper reportMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            reportMapper.getCarsOnParkingAll(parameters);
            cars = (List<Car>) parameters.get(CARS);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return cars;
    }

    @Override
    public List<Car> getCarsOnParkingNow() {
        List<Car> cars;
        SqlSession sqlSession = getSqlSession();
        try {
            ReportMapper reportMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            reportMapper.getCarsOnParkingNow(parameters);
            cars = (List<Car>) parameters.get(CARS);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return cars;
    }
}
