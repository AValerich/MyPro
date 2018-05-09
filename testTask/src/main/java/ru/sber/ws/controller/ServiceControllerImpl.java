package ru.sber.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sber.db.dao.ServiceDAO;
import ru.sber.model.Token;



@RequestMapping("/service")
public class ServiceControllerImpl implements ServiceController {

    @Autowired
    private ServiceDAO serviceDAO;

    @RequestMapping("/getToken")
    @Override
    public Token getToken(String carNumber) {
        Integer tokenId = serviceDAO.setToken(carNumber);
        return serviceDAO.getToken(tokenId);
    }


    @RequestMapping("/updateToken")
    @Override
    public Boolean updateToken(String carNumber, Long tokenId) {
        return serviceDAO.updateToken(carNumber, tokenId);
    }
}
