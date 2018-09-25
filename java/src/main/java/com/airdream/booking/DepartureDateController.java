package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DepartureDateController extends ViewController {

    private BookingWizard bookingWizard;
    private Scanner scanner;

    public DepartureDateController(BookingWizard bookingWizard, Scanner scanner) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
    }

    @Override
    public void show() {
        System.out.println("Select your departure date (DD/MM/YYYY)");
        String date = scanner.nextLine();
        System.out.println("got departure date " + date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date departureDate = simpleDateFormat.parse(date);
            if (departureDate.before(new Date())) {
                System.out.println("Please select a date in the future.");
                show();
            }
            bookingWizard.departureDate = departureDate;
            if (bookingWizard.tripType == 1) {
                bookingWizard.nextStep(new NumberOfPassengersController(bookingWizard, scanner));
            } else {
                bookingWizard.nextStep(new ReturnDateController(bookingWizard, scanner));
            }
        } catch (ParseException e) {
            System.out.println("Invalid input. Please follow the instructions");
            show();
        }
    }
}
