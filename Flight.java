import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Flight {
    // Create the flight info
    public int maxPassenger;
    public int currentCount;
    public List<Passenger> passengers;

    // Constructor
    public Flight(int maxPassenger) {
        this.maxPassenger = maxPassenger;
        this.passengers = new ArrayList<>(maxPassenger);
        this.currentCount = 0;
    }

    // Add a passenger
    public void addPassenger(Passenger passenger) {
        // Checks to see if the maximum number of passengers has been reached

        if (currentCount >= maxPassenger) {

            System.out.println(" The maximum number of passengers have already booked this flight. Cannot add more passengers.");
            return;
        }

        // Checks to see if the passenger with the same passport ID already exists
        for (Passenger existingPassenger : passengers) {

            if (existingPassenger.getPassportId() == passenger.getPassportId()) {
                throw new IllegalArgumentException("A passenger with the same passport ID already exists. Please try again.");
            }
        }

        passengers.add(passenger);
        currentCount++;
    }


    // Book the flight
    public void bookFlight(int passportId) {

        for (int i = 0; i < currentCount; i++) {
            if (passengers.get(i).getPassportId() == passportId) {
                passengers.get(i).bookFlight();
                passengers.get(i).setPurchaseDate(new Date());  // Corrected method name
                System.out.println("The flight is booked for the passenger with the passport ID:" + passportId);
                return;
            }
        }

        System.out.println("Passenger ID not found. Please try again.");
    }

    // Cancel the flight booking
    public void cancelFlight(int passportId) {

        for (int i = 0; i < currentCount; i++) {

            if (passengers.get(i).getPassportId() == passportId) {

                passengers.get(i).cancelFlight();
                System.out.println("Flight canceled for the passenger with the passport ID:" + passportId);
                return;
            }
        }

        System.out.println("Passenger with the given passport ID not found.");
    }

    // Shows all passengers on the flight + their info
    public void displayAllPassengers() {
        System.out.println("Passengers on the flight:");

        for (int i = 0; i < currentCount; i++) {

            passengers.get(i).displayInfo();
            System.out.println("-----------Next Passenger Below----------");
        }

        System.out.println("---------------------");
    }

    // show flight information
    @Override
    public String toString() {

        return "Flight Information:" +
                "\n1. Maximum Passengers on Board: " + maxPassenger +
                "\n2. Count of Passengers Booked: " + currentCount +
                "\n}";
    }

    // Bonus: show passengers who have bought tickets in the last 7 days
    public void displayPassengersLast7Days() {

        System.out.println("Passengers who bought tickets in the last 7 days:");

        Date currentDate = new Date();
        long sevenDays = 7 * 24 * 60 * 60 * 1000L;

        for (int i = 0; i < currentCount; i++) {

            Date purchaseDate = passengers.get(i).getPurchaseDate();

            if (purchaseDate != null && (currentDate.getTime() - purchaseDate.getTime()) <= sevenDays) {

                passengers.get(i).displayInfo();
                System.out.println("Purchase Date: " + purchaseDate);
            }
        }
    }
}