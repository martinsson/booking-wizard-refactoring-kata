package com.airdream.booking.departureCity;

import java.util.Scanner;

public class DepartureCityController implements DepartureCityUIDriver {
    private Scanner scanner;

    public DepartureCityController(Scanner scanner) {

        this.scanner = scanner;
    }

    @Override
    public String getDepartureCity() {
        System.out.println("Select your departure city");
        return scanner.nextLine();
    }

}
