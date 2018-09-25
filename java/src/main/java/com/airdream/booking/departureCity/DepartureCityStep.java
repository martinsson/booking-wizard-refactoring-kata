package com.airdream.booking.departureCity;

import com.airdream.booking.BookingWizard;
import com.airdream.booking.DepartureDateController;
import com.airdream.booking.Step;

import java.util.Scanner;

public class DepartureCityStep implements Step {

    private BookingWizard bookingWizard;
    private Scanner scanner;
    private DepartureCityUIDriver uiDriver;

    public DepartureCityStep(BookingWizard bookingWizard, Scanner scanner, DepartureCityUIDriver uiDriver) {
        this.bookingWizard = bookingWizard;
        this.scanner = scanner;
        this.uiDriver = uiDriver;
    }

    @Override
    public void run() {
        uiDriver.getDepartureCity();
        bookingWizard.nextStep(new DepartureDateController(bookingWizard, scanner));
    }

}