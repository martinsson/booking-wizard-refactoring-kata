package com.airdream.booking;

import java.io.InputStream;

public class ActionBuilder {
    private String departure;
    private String date;
    private String arrival;
    private int number;
    private String name1;

    public ActionBuilder oneWay() {
        return this;
    }

    public ActionBuilder departureCity(String departure) {
        this.departure = departure;
        return this;
    }

    public ActionBuilder departureDate(String date) {
        this.date = date;
        return this;
    }

    public ActionBuilder arrivalCity(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public ActionBuilder passengerNumber(int number) {
        this.number = number;
        return this;
    }

    public ActionBuilder withNames(String name1) {
        this.name1 = name1;
        return this;
    }

    public InputStream andConfirms() {

        return null;
    }
}
