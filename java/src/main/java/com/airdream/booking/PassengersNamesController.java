package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

public class PassengersNamesController extends ViewController {
    private BookingWizard bookingWizard;

    public PassengersNamesController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < bookingWizard.passengers.length; ++i) {
            System.out.println("Please enter the passenger number " + (i + 1) + " first name and last name");
            bookingWizard.passengers[i] = scanner.nextLine();
        }
        bookingWizard.pushViewController(new BookingSummaryController(bookingWizard));
    }
}
