package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

class DepartureCityController extends ViewController {

    private BookingWizard bookingWizard;

    public DepartureCityController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your departure city");
        bookingWizard.departureCity = scanner.nextLine();
        bookingWizard.pushViewController(new DepartureDateController(bookingWizard));
    }
}