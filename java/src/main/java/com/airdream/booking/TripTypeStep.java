package com.airdream.booking;

import java.util.Scanner;

class TripTypeStep implements Step {

    private Scanner scanner;
    BookingWizard bookingWizard;
    private UIDriver uiDriver;

    public TripTypeStep(BookingWizard bookingWizard, Scanner scanner, UIDriver uiDriver) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
        this.uiDriver = uiDriver;
    }

    @Override
    public void run() {

        bookingWizard.tripType = uiDriver.getTripType();
        bookingWizard.nextStep(new DepartureCityController(bookingWizard, scanner));

    }

}