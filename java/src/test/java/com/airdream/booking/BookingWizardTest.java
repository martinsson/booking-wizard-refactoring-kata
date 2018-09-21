package com.airdream.booking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
                .arrivalCity("Lyon")
                .passengerNumber(1)
                .withNames("Fred Brooks")
                .andConfirms();
        System.setIn(actions);
        BookingWizard wizard = new BookingWizard(true);



        wizard.show();

        List<List<String>> edges = wizard.dump();
        List<List<String>> expectedGraph = asList(asList("tripType", "departureCity"));
        Assertions.assertIterableEquals(edges, expectedGraph);
    }
}