package com.airdream.booking;

import com.sdk.ui.ViewController;

public class BookingCancelledController extends ViewController {
    private BookingWizard bookingWizard;

    public BookingCancelledController(BookingWizard bookingWizard) {
        super();
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        System.out.println("We are sorry we could not help you, and hope to see you soon. Good bye.");
    }
}
