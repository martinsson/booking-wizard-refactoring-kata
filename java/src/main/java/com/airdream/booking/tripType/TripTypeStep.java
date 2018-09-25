package com.airdream.booking.tripType;

import com.airdream.booking.BookingWizard;
import com.airdream.booking.Step;
import com.airdream.booking.departureCity.DepartureCityController;
import com.airdream.booking.departureCity.DepartureCityStep;

import java.util.Scanner;

public class TripTypeStep implements Step {

    private Scanner scanner;
    BookingWizard bookingWizard;
    private TripTypeUIDriver tripTypeUiDriver;

    public TripTypeStep(BookingWizard bookingWizard, Scanner scanner, TripTypeUIDriver tripTypeUiDriver) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
        this.tripTypeUiDriver = tripTypeUiDriver;
    }

    @Override
    public void run() {

        bookingWizard.tripType = tripTypeUiDriver.getTripType();
        bookingWizard.nextStep(new DepartureCityStep(bookingWizard, scanner, new DepartureCityController(scanner)));

    }

}