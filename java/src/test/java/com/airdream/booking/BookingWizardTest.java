package com.airdream.booking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookingWizardTest {

    @Test
    void documentation() {
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
        System.setIn(actions);
        BookingWizard wizard = new BookingWizard(true);



        wizard.show();

        Assertions.assertIterableEquals(asList("TripTypeController", "DepartureCityController",
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