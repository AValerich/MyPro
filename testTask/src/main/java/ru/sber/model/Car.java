package ru.sber.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private BigDecimal Id;
    private String number;
    private Boolean OnParking;
    private BigDecimal carPlaceId;

    public BigDecimal getCarPlace() {
        return carPlaceId;
    }

    public void setCarPlace(BigDecimal carPlace) {
        this.carPlaceId = carPlace;
    }

    public BigDecimal getId() {
        return Id;
    }

    public void setId(BigDecimal id) {
        Id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getOnParking() {
        return OnParking;
    }

    public void setOnParking(Boolean onParking) {
        OnParking = onParking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(Id, car.Id) &&
                Objects.equals(number, car.number) &&
                Objects.equals(OnParking, car.OnParking) &&
                Objects.equals(carPlaceId, car.carPlaceId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id, number, OnParking, carPlaceId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "Id=" + Id +
                ", number='" + number + '\'' +
                ", OnParking=" + OnParking +
                ", carPlace=" + carPlaceId +
                '}';
    }
}
