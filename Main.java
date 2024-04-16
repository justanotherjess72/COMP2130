import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    //Set up for the date function below to work

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(dateStr);
        }

        catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-mm-dd.");
            return null;
        }
    }
    //Beginning of Menu

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Flight flight = new Flight(2);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add a passenger");
            System.out.println("2. Book the flight (requires passport ID)");
            System.out.println("3. Cancel the flight (requires passport ID)");
            System.out.println("4. Display all passenger details");
            System.out.println("5. Display all passengers who bought tickets in the last 7 days");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");


            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {


                    //Collects and adds passenger information to the 'database'
                    case 1 -> {
                        System.out.print("Enter the passengers passport ID: ");
                        int passportId = scanner.nextInt();

                        System.out.print("Enter the passengers first name: ");
                        String firstName = scanner.next();

                        System.out.print("Enter the passengers last name: ");
                        String lastName = scanner.next();

                        System.out.print("Enter the passengers age: ");
                        int age = scanner.nextInt();

                        System.out.print("Enter the flight fare: ");
                        double flightFare = scanner.nextDouble();

                        System.out.print("Enter the purchase date of the ticket (yyyy-MM-dd): ");
                        String purchaseDateStr = scanner.next();

                        // Parse the purchaseDateStr to a Date object
                        Date purchaseDate = parseDate(purchaseDateStr);

                        // Prompt user to enter frequent flyer status
                        System.out.print("Is the passenger a frequent flyer? (Enter 'True' for YES, Enter 'False' for NO): ");
                        boolean frequentFlyer = scanner.nextBoolean();

                        // Prompt user to enter Collect Points status
                        System.out.print("Is the passenger collecting points? (Enter 'True' for YES, Enter 'False' for NO): ");
                        boolean collectsMiles = scanner.nextBoolean();

                        // Create a Frequent Flyer Passenger instance
                        FrequentFlyerPassenger passenger;
                        if (frequentFlyer) {
                            passenger = new FrequentFlyerPassenger(passportId, firstName, lastName, age, flightFare, false, purchaseDate, true, true);
                        } else {
                            passenger = new FrequentFlyerPassenger(passportId, firstName, lastName, age, flightFare, false, purchaseDate, false, false);
                        }

                        // Add the passenger to the flight
                        flight.addPassenger(passenger);
                    }


                    //Book the flight
                    case 2 -> {
                        System.out.print("Enter passport ID to book the flight: ");
                        int bookPassportId = scanner.nextInt();

                        flight.bookFlight(bookPassportId);
                    }


                    //Cancel the flight
                    case 3 -> {
                        System.out.print("Enter passport ID to cancel the flight: ");
                        int cancelPassportId = scanner.nextInt();

                        flight.cancelFlight(cancelPassportId);
                    }


                    //Show all the passengers on the flight
                    case 4 -> flight.displayAllPassengers();


                    //Show all passengers who booked in the last 7 days
                    case 5 -> flight.displayPassengersLast7Days();


                    //Exit program
                    case 6 -> {
                        System.out.println("Closing the program.");

                        scanner.close();
                        System.exit(0);
                    }

                    //In the event of an incorrect entry
                    default -> System.out.println("Invalid choice. Please try again.");
                }


            } catch (IllegalArgumentException e) {
                // Catch the IllegalArgumentException (thrown when duplicate passport ID is found)
                System.err.println("Error: " + e.getMessage());


            } catch (Exception e) {
                // Catch any other exceptions
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

}
