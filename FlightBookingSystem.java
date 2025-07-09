import java.util.*;

class Flight {
    String flightNumber;
    String source;
    String destination;
    int availableSeats;
    double price;

    public Flight(String flightNumber, String source, String destination, int availableSeats, double price) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Flight: " + flightNumber + " | From: " + source + " To: " + destination +
                " | Seats: " + availableSeats + " | Price: ₹" + price);
    }
}

class Booking {
    Flight flight;
    String passengerName;
    int seatsBooked;

    public Booking(Flight flight, String passengerName, int seatsBooked) {
        this.flight = flight;
        this.passengerName = passengerName;
        this.seatsBooked = seatsBooked;
    }

    public double calculateTotal() {
        return flight.price * seatsBooked;
    }

    public void displayBooking() {
        System.out.println("Booking confirmed for " + passengerName);
        System.out.println("Flight: " + flight.flightNumber + " | Seats: " + seatsBooked + " | Total: ₹" + calculateTotal());
    }
}

public class FlightBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AI101", "Delhi", "Mumbai", 10, 4500.0));
        flights.add(new Flight("6E202", "Hyderabad", "Bangalore", 8, 3200.0));
        flights.add(new Flight("SG303", "Chennai", "Kolkata", 12, 4800.0));

        System.out.println("Welcome to Java Flight Booking System!");
        System.out.println("Available Flights:");
        for (int i = 0; i < flights.size(); i++) {
            System.out.print((i + 1) + ". ");
            flights.get(i).displayInfo();
        }

        System.out.print("Choose flight (1-" + flights.size() + "): ");
        int choice = sc.nextInt();
        Flight selectedFlight = flights.get(choice - 1);

        System.out.print("Enter your name: ");
        sc.nextLine();  // consume newline
        String name = sc.nextLine();

        System.out.print("Enter number of seats to book: ");
        int seats = sc.nextInt();

        if (seats <= selectedFlight.availableSeats) {
            selectedFlight.availableSeats -= seats;
            Booking booking = new Booking(selectedFlight, name, seats);

            System.out.println("Processing payment...");
            System.out.println("Payment of ₹" + booking.calculateTotal() + " successful!");

            booking.displayBooking();
        } else {
            System.out.println("Sorry, not enough seats available.");
        }

        sc.close();
    }
}
