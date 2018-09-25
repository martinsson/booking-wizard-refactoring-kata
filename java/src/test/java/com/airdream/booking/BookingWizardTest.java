package com.airdream.booking;

import com.airdream.adapter.NavigationBridge;
import com.sdk.ui.NavigationController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Scanner;

import static java.util.Arrays.asList;

class BookingWizardTest {

    @Test
    void documentation() {
        InputStream actions = new ActionBuilder()
                .oneWay()
                .departureCity("London")
                .departureDate("19/09/2019")
                .passengerNumber(1)
                .withNames("Fred Brooks")
                .arrivalCity("Lyon")
                .andConfirms();

        BookingWizard wizard = new BookingWizard(true, new NavigationBridge(new NavigationController()));
        System.setIn(actions);

        wizard.start();

        Assertions.assertIterableEquals(asList("TripTypeStep", "DepartureCityController",
                "DepartureDateController",
                "NumberOfPassengersController",
                "PassengersNamesController",
                "BookingSummaryController",
                "BookingConfirmedController"), wizard.stepsSimple);
    }

    @Test
    void actionBuilder() {
        ActionBuilder userChooses = new ActionBuilder();
        InputStream actions = userChooses
                .oneWay()
                .departureCity("London")
                .departureDate("19/09/2019")
                .passengerNumber(1)
                .withNames("Fred Brooks")
                .arrivalCity("Lyon")
//                .returnDate("21/09/2019")
                .andConfirms();
        Scanner scanner = new Scanner(actions);
        scanner.nextInt();
        Assertions.assertEquals(" London", scanner.nextLine());
        Assertions.assertEquals("19/09/2019", scanner.nextLine());
        Assertions.assertEquals(1, scanner.nextInt());
        Assertions.assertEquals(" Fred Brooks", scanner.nextLine());
        Assertions.assertEquals("Lyon", scanner.nextLine());

    }
}