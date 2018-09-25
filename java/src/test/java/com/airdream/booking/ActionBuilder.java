package com.airdream.booking;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionBuilder {
    private String departure;
    private String date;
    private String arrival;
    private int passengerCount;
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
        this.passengerCount = number;
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
                passengerCount + " " + name1,
                arrival,
                "Yes"
        )
                .collect(Collectors.joining("\n"));
        return new ByteArrayInputStream(userInput.getBytes());
    }

    public Map<String, String> andConfirmsMap() {
        return new HashMap<String, String>() {{
            put("tripType", String.valueOf(tripType));
            put("departure", departure);
            put("date", date);
            put("passengerCount", String.valueOf(passengerCount));
            put("name1", name1);
            put("arrival", arrival);
            put("confirms?", "Yes");
        }};
    }
}
