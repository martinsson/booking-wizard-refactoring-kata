package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfPassengersController extends ViewController {

    private BookingWizard bookingWizard;
    private Scanner scanner;

    public NumberOfPassengersController(BookingWizard bookingWizard, Scanner scanner) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        try {
            System.out.println("Please select the number of passengers");
            int size = scanner.nextInt();
            bookingWizard.passengers = new String[size];
            bookingWizard.pushViewController(new PassengersNamesController(bookingWizard, scanner));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please follow the instructions");
            show();
        }
    }
}
