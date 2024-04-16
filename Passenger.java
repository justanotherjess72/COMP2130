import java.util.Date;


public class Passenger {

    public int passportId;
    public String firstName;
    public String lastName;
    public int age;
    public double flightFare;
    public boolean hasBooked;
    public Date purchaseDate;


    //// CONSTRUCTOR ////
    public Passenger(int passportId, String firstName, String lastName,
                     int age, double flightFare, Date purchaseDate) {
        this.passportId = passportId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.flightFare = flightFare;
        this.purchaseDate = purchaseDate;

    }


    // BOOKING METHODS

    public boolean bookFlight() {
        return hasBooked = true;
    }
    public boolean cancelFlight(){
        return hasBooked = false;
    }


    // GET METHODS //

    public int getPassportId() {
        return passportId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    // SET METHODS //

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    // DISPLAY INFO //
    public void displayInfo() {
        System.out.println("Passport Id: " + passportId +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAge: " + age +
                "\nFlight Fare: " + flightFare +
                "\nHas Booked: " + hasBooked +
                "\nPurchase Date: " + purchaseDate +
                "\nFrequent Flyer:" + FrequentFlyerPassenger.FrequentFlyer() +
                "\nCollects Miles: " + FrequentFlyerPassenger.CollectsMiles());

    }

    // TO STRING OVER-RIDE //
    @Override
    public String toString() {
        return "Passenger Information: " +
                "Passport Id: " + passportId +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastName +
                "\n Age: " + age +
                "\n Flight Fare: " + flightFare +
                "\n Has Booked: " + hasBooked +
                "\nPurchase Date: " + purchaseDate + super.toString() +
                "\n---------------------";

    }
}

// Bonus Question : extend passenger class as FrequentFlyerPassenger
// include two new attributes: frequentFlyer, collectsMiles
class FrequentFlyerPassenger extends Passenger {

    public static boolean frequentFlyer;
    public static boolean collectsMiles;
    public FrequentFlyerPassenger(int passportId, String firstName, String lastName, int age, double flightFare,
                                  boolean hasBooked, Date purchaseDate, boolean frequentFlyer, boolean collectsMiles) {
        super(passportId, firstName, lastName, age, flightFare, purchaseDate);
        FrequentFlyerPassenger.frequentFlyer = frequentFlyer;
        FrequentFlyerPassenger.collectsMiles = collectsMiles;
    }

    // METHODS //
    public static boolean FrequentFlyer(){
        return frequentFlyer;

    }

    public static boolean CollectsMiles(){
        return collectsMiles;
    }

    public static boolean isFrequentFlyer() {
        return frequentFlyer = false;
    }

    public static boolean isCollectsMiles() {
        return collectsMiles = false;
    }

    public static void setFrequentFlyer(boolean frequentFlyer) {
        FrequentFlyerPassenger.frequentFlyer = frequentFlyer;
    }

    public static void setCollectsMiles(boolean collectsMiles) {
        FrequentFlyerPassenger.collectsMiles = collectsMiles;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Passenger Information: " +
                "Passport Id: " + passportId +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastName +
                "\n Age: " + age +
                "\n Flight Fare: " + flightFare +
                "\n Has Booked: " + hasBooked +
                "\nPurchase Date: " + purchaseDate +
                "\nFrequent Flyer: " + frequentFlyer +
                "\nCollects Miles: " + collectsMiles;
    }


}

