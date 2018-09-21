package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

public class ArrivalCityController extends ViewController {

    private BookingWizard bookingWizard;
    private Scanner scanner;

    public ArrivalCityController(BookingWizard bookingWizard, Scanner scanner) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("Select your arrival city");
        bookingWizard.arrivalCity = scanner.nextLine();
        bookingWizard.pushViewController(new ArrivalCityController(bookingWizard, scanner));
    }
}
