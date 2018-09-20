package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.InputMismatchException;
import java.util.Scanner;

class TripTypeController extends ViewController {

    BookingWizard bookingWizard;

    public TripTypeController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Hello,  welcome to Airdream, the airline of your dreams");
            System.out.println("What kind of flight do you want to book?");
            System.out.println("[1] outward");
            System.out.println("[2] round trip");
            int tripType = scanner.nextInt();
            if (tripType != 1 && tripType != 2) {
                System.out.println("Invalid input. Please follow the instructions");
                this.show();
            }
            if (bookingWizard != null) {
                bookingWizard.tripType = tripType;
            }
            bookingWizard.pushViewController(new DepartureCityController(bookingWizard));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please follow the instructions");
            this.show();
        }

    }
}