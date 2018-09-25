package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.InputMismatchException;
import java.util.Scanner;

class TripTypeController extends ViewController {

    private final TripTypeView view;
    private Scanner scanner;
    BookingWizard bookingWizard;

    public TripTypeController(BookingWizard bookingWizard, TripTypeView view, Scanner scanner) {
        this.bookingWizard = bookingWizard;
        this.view = view;
        this.scanner = scanner;
    }

    @Override
    public void show() {

        try {
            int tripType = view.askOneWayOrRoundTrip();
            System.out.println("got triptype " + tripType);

            if (tripType != 1 && tripType != 2) {
                System.out.println("Invalid input. Please follow the instructions");
                this.show();
            }
            if (bookingWizard != null) {
                bookingWizard.tripType = tripType;
            }

        } catch (InputMismatchException e) {

            System.out.println("Invalid input. Please follow the instructions");
            this.show();
            return;
        }

        bookingWizard.nextStep(new DepartureCityController(bookingWizard, scanner));

    }

}