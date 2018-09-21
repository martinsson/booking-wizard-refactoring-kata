package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

class DepartureCityController extends ViewController {

    private BookingWizard bookingWizard;
    private Scanner scanner;

    public DepartureCityController(BookingWizard bookingWizard, Scanner scanner) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("Select your departure city");
        bookingWizard.departureCity = scanner.nextLine();
        bookingWizard.pushViewController(new DepartureDateController(bookingWizard, scanner));
    }
}