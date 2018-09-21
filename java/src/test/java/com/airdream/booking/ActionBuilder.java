package com.airdream.booking;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionBuilder {
    private String departure;
    private String date;
    private String arrival;
    private int number;
    private String name1;
    private int tripType;
    private String returnDate;

    public ActionBuilder oneWay() {
        this.tripType = 1;
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

    public ActionBuilder returnDate(String returnDate) {
        this.returnDate = returnDate;
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
        String userInput = Stream.of(
                tripType + " " + departure,
                date,
                number + " " + name1,
                arrival,
//                returnDate,
                "Yes"
        )
                .collect(Collectors.joining("\n"));
        return new ByteArrayInputStream(userInput.getBytes());
    }

}
