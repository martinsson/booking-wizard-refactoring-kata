package com.airdream.booking.tripType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TripTypeController implements TripTypeUIDriver {

    private Scanner scanner;

    public TripTypeController(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getTripType() {
        try {
            System.out.println("Hello,  welcome to Airdream, the airline of your dreams");
            System.out.println("What kind of flight do you want to book?");
            System.out.println("[1] outward");
            System.out.println("[2] round trip");
            int tripType = scanner.nextInt();
            System.out.println("got triptype " + tripType);


            if (tripType != 1 && tripType != 2) {
                System.out.println("Invalid input. Please follow the instructions");
                return this.getTripType();
            }
            return tripType;

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please follow the instructions");
            return this.getTripType();
        }

    }


}
