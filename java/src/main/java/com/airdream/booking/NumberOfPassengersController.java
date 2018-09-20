package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfPassengersController extends ViewController {

    private BookingWizard bookingWizard;

    public NumberOfPassengersController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please select the number of passengers");
            int size = scanner.nextInt();
            bookingWizard.passengers = new String[size];
            bookingWizard.pushViewController(new PassengersNamesController(bookingWizard));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please follow the instructions");
            show();
        }
    }
}
