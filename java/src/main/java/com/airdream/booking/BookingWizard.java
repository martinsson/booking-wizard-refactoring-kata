package com.airdream.booking;

import com.sdk.ui.NavigationController;
import com.sdk.ui.ViewController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

// data passes between controllers argument passing and casting, or by global object
// Only the bookingwizard knows about the next step
// Booking wizard is the framework, is the data

class TripTypeController extends ViewController {

    BookingWizard bookingWizard;

    public TripTypeController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Hello,  welcome to Airdream, the airline of your dreams");
            System.out.println("What kind of flight do you want to book?");
            System.out.println("[1] outward");
            System.out.println("[2] round trip");
            int tripType = scanner.nextInt();
            if (tripType != 1 && tripType != 2) {
                System.out.println("Invalid input. Please follow the instructions");
                this.show();
            }
            bookingWizard.goToDepartureCityChoice(tripType);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please follow the instructions");
            this.show();
        }

    }
}

class DepartureCityController extends ViewController {

    private BookingWizard bookingWizard;

    public DepartureCityController(BookingWizard bookingWizard) {
        this.bookingWizard = bookingWizard;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your departure city");
        String departureCity = scanner.nextLine();
        bookingWizard.goToDateSelection(departureCity);
    }
}

public class BookingWizard extends NavigationController {

    private int currentStep = 0;
    private int tripType;
    private String departureCity;
    private String arrivalCity;
    private Date departureDate;
    private Date returnDate;
    private String[] passengers;
    private Boolean confirmed = null;

    public static void main(String[] args) {
        new BookingWizard().show();
    }

    @Override
    public void show() {
        currentStep = 0;
        while (currentStep < 9) {
            wizardStep();
            ++currentStep;
        }
    }

    private void wizardStep() {

        Scanner scanner = new Scanner(System.in);

        if (currentStep == 0) {
            this.pushViewController(new TripTypeController(this));
            currentStep++;
        } else if (currentStep == 2) {
            System.out.println("Select your arrival city");
            arrivalCity = scanner.nextLine();
        } else if (currentStep == 3) {
            System.out.println("Select your departure date (DD/MM/YYYY)");
            String date = scanner.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                departureDate = simpleDateFormat.parse(date);
                if (departureDate.before(new Date())) {
                    System.out.println("Please select a date in the future.");
                    wizardStep();
                }
            } catch (ParseException e) {
                System.out.println("Invalid input. Please follow the instructions");
                wizardStep();
            }
        } else if (currentStep == 4) {
            if (tripType == 2) {
                System.out.println("Select your return date (DD/MM/YYYY)");
                String date = scanner.nextLine();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    returnDate = simpleDateFormat.parse(date);
                    if (returnDate.before(new Date())) {
                        System.out.println("Please select a date in the future.");
                        wizardStep();
                    } else {
                        if (returnDate.before(departureDate)) {
                            System.out.println("Please select a return date after your departure date.");
                            wizardStep();
                        }
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid input. Please follow the instructions");
                    wizardStep();
                }
            }
        } else if (currentStep == 5) {
            try {
                System.out.println("Please select the number of passengers");
                int size = scanner.nextInt();
                passengers = new String[size];
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please follow the instructions");
                wizardStep();
            }
        } else if (currentStep == 6) {
            for (int i = 0; i < passengers.length; ++i) {
                System.out.println("Please enter the passenger number " + (i + 1) + " first name and last name");
                passengers[i] = scanner.nextLine();
            }
        } else if (currentStep == 7) {
            System.out.println("Your booking summary");
            System.out.println("Flight 1: "
                    + "Departure at " + departureDate.toString() + " from " + departureCity + " and arrival in " + arrivalCity);
            if (returnDate != null) {
                System.out.println("Flight 2: "
                        + "Departure at " + returnDate.toString() + " from " + arrivalCity + " and arrival in " + departureCity);
            }
            System.out.println("Passengers:");
            for (int i = 0; i < passengers.length; ++i) {
                System.out.println(passengers[i]);
            }
            System.out.println("Do you confirm? [Yes/No]");
            String confirmation = scanner.nextLine();
            switch (confirmation) {
                case "Yes":
                    confirmed = true;
                    break;
                case "No":
                    confirmed = false;
                    break;
                default:
                    System.out.println("Invalid input. Please follow the instructions");
                    wizardStep();
                    break;
            }
        } else if (currentStep == 8) {
            if (confirmed == null) {
                currentStep--;
                wizardStep();
            } else {
                if (confirmed) {
                    System.out.println("Thank you for your booking, we wish you an excellent trip to " + arrivalCity);
                } else {
                    System.out.println("We are sorry we could not help you, and hope to see you soon. Good bye.");
                }
            }
        }
    }

    public void goToDepartureCityChoice(int tripType) {
        this.tripType = tripType;
        this.pushViewController(new DepartureCityController(this));
    }

    public void done(Object o) {
        // or we could pass the an instance of a booking object that contains
        // all the primitives: tripType, departureCity, ...
        this.currentStep++;
        ViewController viewController = null;
        switch (currentStep) {
            case 0 :
                this.tripType = (int) o;
                viewController = new TripTypeController(this);
                break;
            case 1 :
                this.departureCity = (String) o;
                viewController = new DepartureCityController(this);
                break;

            default:
                break;
        }
        if (viewController != null) {
            this.pushViewController(viewController);

        }
    }

    public void goToDateSelection(String departureCity) {
        this.departureCity = departureCity;
    }
}
