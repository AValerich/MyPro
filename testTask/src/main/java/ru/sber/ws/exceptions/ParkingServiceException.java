package ru.sber.ws.exceptions;

public class ParkingServiceException extends Exception {

    public ParkingServiceException(String message) {
        super(message);
    }

    public ParkingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingServiceException(Throwable cause) {
        super(cause);
    }
}
