package com.airdream.booking;

import com.sdk.ui.NavigationController;
import com.sdk.ui.ViewController;

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
    private List<List<String>> steps = new ArrayList<>();
    public List<String> stepsSimple = new ArrayList<>();

    public BookingWizard(boolean dryrun) {

        this.dryrun = dryrun;
    }

    @Override
    public void pushViewController(ViewController viewController) {
        stepsSimple.add(viewController.getClass().getSimpleName());
        super.pushViewController(viewController);
    }

    public static void main(String[] args) {
        new BookingWizard(false).show();
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        this.pushViewController(new TripTypeController(this, new TripTypeView(scanner), scanner));
    }

    public List<List<String>> dump() {
        return this.steps;
    }
    public List<List<String>> dump2() {

        for (int i = 0; i < stepsSimple.size() - 1; i++) {
            steps.add(Arrays.asList(stepsSimple.get(i), stepsSimple.get(i + 1)));
        }
        return steps;

    }

    public void addExecutionLog(String currentController, String nextController) {
        this.steps.add(Arrays.asList(currentController, nextController));
    }
}
