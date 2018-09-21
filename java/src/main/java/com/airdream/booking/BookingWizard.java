package com.airdream.booking;

import com.sdk.ui.NavigationController;

import java.io.InputStream;
import java.util.*;

public class BookingWizard extends NavigationController {

    int tripType;
    String departureCity;
    String arrivalCity;
    Date departureDate;
    Date returnDate;
    String[] passengers;
    boolean dryrun;
    private List<List<String>> steps = new ArrayList();

    public BookingWizard(boolean dryrun) {

        this.dryrun = dryrun;
    }

    public static void main(String[] args) {
        new BookingWizard(false).show();
    }

    @Override
    public void show() {
        this.pushViewController(new TripTypeController(this, new TripTypeView()));
    }

    public List<List<String>> dump() {
        return this.steps;
    }

    public void addExecutionLog(String currentController, String nextController) {
        this.steps.add(Arrays.asList(currentController, nextController));
    }
}
