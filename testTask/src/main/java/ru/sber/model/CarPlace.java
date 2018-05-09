package ru.sber.model;

import java.time.LocalDate;
import java.util.Objects;

public class CarPlace {

    private Integer parkId;
    private Long carPlaceId;
    private Boolean isEmpty;
    private Long carId;
    private LocalDate timeFrom;
    private LocalDate timeTo;

    public LocalDate getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDate timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDate getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDate timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Long getCarPlaceId() {
        return carPlaceId;
    }

    public void setCarPlaceId(Long carPlaceId) {
        this.carPlaceId = carPlaceId;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPlace carPlace = (CarPlace) o;
        return Objects.equals(parkId, carPlace.parkId) &&
                Objects.equals(carPlaceId, carPlace.carPlaceId) &&
                Objects.equals(isEmpty, carPlace.isEmpty) &&
                Objects.equals(carId, carPlace.carId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(parkId, carPlaceId, isEmpty, carId);
    }

    @Override
    public String toString() {
        return "CarPlace{" +
                "parkId=" + parkId +
                ", carPlaceId=" + carPlaceId +
                ", isEmpty=" + isEmpty +
                ", carId=" + carId +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                '}';
    }
}
