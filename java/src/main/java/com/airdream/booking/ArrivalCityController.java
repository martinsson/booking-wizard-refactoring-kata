package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.Scanner;

public class ArrivalCityController extends ViewController {

    private BookingWizard bookingWizard;

    public ArrivalCityController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your arrival city");
        bookingWizard.arrivalCity = scanner.nextLine();
        bookingWizard.pushViewController(new ArrivalCityController(bookingWizard));
    }
}
