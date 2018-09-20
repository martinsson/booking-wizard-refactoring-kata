package com.airdream.booking;

import com.sdk.ui.ViewController;

public class BookingConfirmedController extends ViewController {
    private BookingWizard bookingWizard;

    public BookingConfirmedController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        System.out.println("Thank you for your booking, we wish you an excellent trip to " + bookingWizard.arrivalCity);
    }
}
