package ru.sber.ws.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.sber.model.Token;

@RestController
public interface ServiceController {

    Token getToken(String carNumber);

    Boolean updateToken(String carNumber, Long tokenId);
}
