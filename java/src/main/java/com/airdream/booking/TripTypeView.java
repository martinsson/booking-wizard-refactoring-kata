package com.airdream.booking;

import java.util.Scanner;

class TripTypeView {

    private Scanner scanner;

    public TripTypeView(Scanner scanner) {

        this.scanner = scanner;
    }

    public int askOneWayOrRoundTrip() {
        System.out.println("Hello,  welcome to Airdream, the airline of your dreams");
        System.out.println("What kind of flight do you want to book?");
        System.out.println("[1] outward");
        System.out.println("[2] round trip");
        return scanner.nextInt();
    }
}
