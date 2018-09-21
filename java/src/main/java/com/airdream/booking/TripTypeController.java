package com.airdream.booking;

import com.sdk.ui.ViewController;

import java.util.InputMismatchException;

class TripTypeController extends ViewController {

    private final TripTypeView view;
    BookingWizard bookingWizard;

    public TripTypeController(BookingWizard bookingWizard, TripTypeView view) {
        this.bookingWizard = bookingWizard;
        this.view = view;
    }

    @Override
    public void show() {

        if (bookingWizard.dryrun) {
            bookingWizard.addExecutionLog("tripType", "departureCity");
            return;
        }
        try {
            int tripType = view.askOneWayOrRoundTrip();
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

        bookingWizard.pushViewController(new DepartureCityController(bookingWizard));

    }

}