package com.airdream.booking;

import com.sdk.ui.NavigationController;

import java.util.Date;

public class BookingWizard extends NavigationController {

    int tripType;
    String departureCity;
    String arrivalCity;
    Date departureDate;
    Date returnDate;
    String[] passengers;

    public static void main(String[] args) {
        new BookingWizard().show();
    }

    @Override
    public void show() {
        this.pushViewController(new TripTypeController(this));
    }
}
