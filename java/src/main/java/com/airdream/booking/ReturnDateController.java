package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReturnDateController extends ViewController {
    private BookingWizard bookingWizard;
    private Scanner scanner;

    public ReturnDateController(BookingWizard bookingWizard, Scanner scanner) {

        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("Select your return date (DD/MM/YYYY)");
        String date = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date returnDate = simpleDateFormat.parse(date);
            if (returnDate.before(new Date())) {
                System.out.println("Please select a date in the future.");
                show();
            } else {
                if (returnDate.before(bookingWizard.departureDate)) {
                    System.out.println("Please select a return date after your departure date.");
                    show();
                } else {
                    bookingWizard.returnDate = returnDate;
                    bookingWizard.nextStep(new NumberOfPassengersController(bookingWizard, scanner));
                }
            }
        } catch (ParseException e) {
            System.out.println("Invalid input. Please follow the instructions");
            show();
        }
    }
}
