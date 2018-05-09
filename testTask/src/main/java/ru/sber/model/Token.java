package ru.sber.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Token {

    private Long tokenId;
    private Long carPlaceId;
    private Integer carId;
    private BigDecimal amount;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Integer getCar() {
        return carId;
    }

    public void setCar(Integer car) {
        this.carId = carId;
    }

    public Long getCarPlaceId() {
        return carPlaceId;
    }

    public void setCarPlaceId(Long carPlaceId) {
        this.carPlaceId = carPlaceId;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(tokenId, token.tokenId) &&
                Objects.equals(carPlaceId, token.carPlaceId) &&
                Objects.equals(carId, token.carId) &&
                Objects.equals(amount, token.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tokenId, carPlaceId, carId, amount);
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId=" + tokenId +
                ", carPlaceId=" + carPlaceId +
                ", car=" + carId +
                ", amount=" + amount +
                '}';
    }
}
