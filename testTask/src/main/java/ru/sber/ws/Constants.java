package ru.sber.ws;

public class Constants {

    public static final String CAR_NUMBER = "carNumber";
    public static final String TOKEN = "token";
    public static final String ON_PARKING = "onParking";
    public static final String CAR_PLACES = "carPlaces";
    public static final String CARS = "cars";

    public enum ParkingStatus{
        Y("Y"), N("N");

        private final String name;

        ParkingStatus(String name) {
            this.name = name;
        }

    }

    private Constants() {throw  new UnsupportedOperationException();}
}
