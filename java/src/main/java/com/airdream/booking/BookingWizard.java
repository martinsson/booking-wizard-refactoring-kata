package com.airdream.booking;

import com.sdk.ui.NavigationController;
import com.sdk.ui.ViewController;

import java.util.*;

public class BookingWizard {

    int tripType;
    String departureCity;
    String arrivalCity;
    Date departureDate;
    Date returnDate;
    String[] passengers;
    boolean dryrun;
    private NavigationController navigation;
    private List<List<String>> steps = new ArrayList<>();
    public List<String> stepsSimple = new ArrayList<>();

    public BookingWizard(boolean dryrun) {
        this.dryrun = dryrun;
    }

    public BookingWizard(boolean dryrun, NavigationController navigation) {
        this.dryrun = dryrun;
        this.navigation = navigation;
    }

    public BookingWizard(boolean b, Map<String, String> actions) {

    }

    public void nextStep(ViewController viewController) {
        stepsSimple.add(viewController.getClass().getSimpleName());
        navigation.pushViewController(viewController);
    }

    public static void main(String[] args) {
        new BookingWizard(false).start();
    }

    public void start() {
        navigation.show();
        Scanner scanner = new Scanner(System.in);

        this.nextStep(new TripTypeController(this, new TripTypeView(scanner), scanner));
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
