package ru.sber.db.dao;

import java.util.Map;

public interface ServiceMapper {

    void setNewToken(Map<String, Object> parameter);

    void getNewToken(Map<String, Object> parameter);

    void updateToken(Map<String, Object> parameter);
}
