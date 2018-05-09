package ru.sber.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parking {

    private BigDecimal parkId;
    private List<Car> cars;
    private List<CarPlace> carPlaces;

    public BigDecimal getParkId() {
        return parkId;
    }

    public void setParkId(BigDecimal parkId) {
        this.parkId = parkId;
    }

    public List<Car> getCars() {
        if (cars == null) {
            cars = new ArrayList<>();
        }
        return cars;
    }

    public List<CarPlace> getCarPlaces() {
        if (carPlaces == null) {
            carPlaces = new ArrayList<>();
        }
        return carPlaces;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(parkId, parking.parkId) &&
                Objects.equals(cars, parking.cars) &&
                Objects.equals(carPlaces, parking.carPlaces);
    }

    @Override
    public int hashCode() {

        return Objects.hash(parkId, cars, carPlaces);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkId=" + parkId +
                ", cars=" + cars +
                ", carPlaces=" + carPlaces +
                '}';
    }
}
