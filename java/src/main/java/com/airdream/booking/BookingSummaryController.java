package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

public class BookingSummaryController extends ViewController {

    private BookingWizard bookingWizard;
    private Scanner scanner;

    public BookingSummaryController(BookingWizard bookingWizard, Scanner scanner) {

        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("Your booking summary");
        System.out.println("Flight 1: "
                + "Departure at " + bookingWizard.departureDate.toString() + " from " + bookingWizard.departureCity + " and arrival in " + bookingWizard.arrivalCity);
        if (bookingWizard.returnDate != null) {
            System.out.println("Flight 2: "
                    + "Departure at " + bookingWizard.returnDate.toString() + " from " + bookingWizard.arrivalCity + " and arrival in " + bookingWizard.departureCity);
        }
        System.out.println("Passengers:");
        for (int i = 0; i < bookingWizard.passengers.length; ++i) {
            System.out.println(bookingWizard.passengers[i]);
        }
        System.out.println("Do you confirm? [Yes/No]");
        String confirmation = scanner.nextLine();
        switch (confirmation) {
            case "Yes":
                bookingWizard.pushViewController(new BookingConfirmedController(bookingWizard));
                break;
            case "No":
                bookingWizard.pushViewController(new BookingCancelledController(bookingWizard));
                break;
            default:
                System.out.println("Invalid input. Please follow the instructions");
                show();
                break;
        }
    }
}
