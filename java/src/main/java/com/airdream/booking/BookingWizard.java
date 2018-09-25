package com.airdream.booking;

import com.airdream.adapter.NavigationBridge;
import com.airdream.booking.tripType.TripTypeController;
import com.airdream.booking.tripType.TripTypeStep;
import com.sdk.ui.ViewController;

import java.util.*;

public class BookingWizard {

    private NavigationBridge navigationBridge;
    public int tripType;
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

    public BookingWizard(boolean dryrun, NavigationBridge navigationBridge) {
        this.dryrun = dryrun;
        this.navigationBridge = navigationBridge;
    }

    public BookingWizard(boolean b, Map<String, String> actions) {

    }

    public void nextStep(ViewController viewController) {
        stepsSimple.add(viewController.getClass().getSimpleName());
        navigationBridge.navigation.pushViewController(viewController);
    }

    public void nextStep(Step step) {
        stepsSimple.add(step.getClass().getSimpleName());
        navigationBridge.nextStepBridge(step);
    }

    public static void main(String[] args) {
        new BookingWizard(false).start();
    }

    public void start() {
        navigationBridge.navigation.show();
        Scanner scanner = new Scanner(System.in);

        this.nextStep(new TripTypeStep(this, scanner, new TripTypeController(scanner)));
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
