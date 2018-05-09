package ru.sber.db.dao;

import org.apache.ibatis.session.SqlSession;
import ru.sber.model.Token;
import ru.sber.ws.Constants;
import ru.sber.ws.controller.ServiceController;

import java.util.HashMap;
import java.util.Map;

import static ru.sber.ws.Constants.*;

public class ServiceDAO extends MyBatisDAO<ServiceMapper> {


    @Override
    public ServiceMapper getMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(ServiceMapper.class);
    }

    public Token getToken(Integer carNumber) {
        Token token;
        SqlSession sqlSession = getSqlSession();
        try {
            ServiceMapper serviceMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("tokenid", carNumber);
            serviceMapper.getNewToken(parameters);
            token = (Token) parameters.get(TOKEN);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return token;
    }

    public Boolean updateToken(String carNumber, Long tokenId) {
        String status;
        SqlSession sqlSession = getSqlSession();
        try {
            ServiceMapper serviceMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put(CAR_NUMBER,carNumber);
            parameters.put("tokenId",carNumber);
            serviceMapper.updateToken(parameters);
            status = (String) parameters.get(ON_PARKING);
        } finally {
            if (sqlSession != null) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
        return Constants.ParkingStatus.Y.equals(status);
    }

    public Integer setToken(String carNumber) {
        Integer tokenId;
        SqlSession sqlSession = getSqlSession();
        try {
            ServiceMapper serviceMapper = this.getMapper(sqlSession);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put(CAR_NUMBER, carNumber);
            serviceMapper.setNewToken(parameters);
            tokenId = (Integer) parameters.get(TOKEN);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return tokenId;
    }
}
