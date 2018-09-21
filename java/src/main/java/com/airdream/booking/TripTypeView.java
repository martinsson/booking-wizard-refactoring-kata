package com.airdream.booking;

import java.util.Scanner;

class TripTypeView {

    public int askOneWayOrRoundTrip() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello,  welcome to Airdream, the airline of your dreams");
        System.out.println("What kind of flight do you want to book?");
        System.out.println("[1] outward");
        System.out.println("[2] round trip");
        return scanner.nextInt();
    }
}
