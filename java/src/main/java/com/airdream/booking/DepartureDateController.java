package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DepartureDateController extends ViewController {

    private BookingWizard bookingWizard;

    public DepartureDateController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your departure date (DD/MM/YYYY)");
        String date = scanner.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date departureDate = simpleDateFormat.parse(date);
            if (departureDate.before(new Date())) {
                System.out.println("Please select a date in the future.");
                show();
            }
            bookingWizard.departureDate = departureDate;
            if (bookingWizard.tripType == 1) {
                bookingWizard.pushViewController(new NumberOfPassengersController(bookingWizard));
            } else {
                bookingWizard.pushViewController(new ReturnDateController(bookingWizard));
            }
        } catch (ParseException e) {
            System.out.println("Invalid input. Please follow the instructions");
            show();
        }
    }
}
