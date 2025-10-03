import java.util.ArrayList;

/**
 * BunnyAirwaysSystem class is used to manage all the operations of the
 * main menu.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class BunnyAirwaysSystem
{
    // ArrayLists to store the customers, flights and flight tickets
    private static final ArrayList<Customer> CUSTOMERS
            = new ArrayList<Customer>();
    private static final ArrayList<Flight> FLIGHTS = new ArrayList<Flight>();
    private static final ArrayList<FlightTicket> FLIGHT_TICKETS
            = new ArrayList<FlightTicket>();

    public BunnyAirwaysSystem()
    {

    }

    /**
     * Adds a new flight to the BunnyAirwaysSystem.
     */
    public void addNewFlight()
    {
        Input input = new Input();
        // Prompt the user for the flight details
        String route = input.routeInput();
        int totalSeats = input.totalSeatsInput();
        double baseFare = input.baseFareInput();

        Flight flight = new Flight(route, totalSeats, baseFare);
        FLIGHTS.add(flight);

        System.out.println("---------------------------------------------");
        System.out.println("Flight added successfully.\n" + flight);
    }

    /**
     * Books a flight ticket for a customer.
     */
    public void bookFlightTicket()
    {
        Input input = new Input();
        Customer currentCustomer;
        Flight currentFlight;

        // Check if there are no customers registered
        if (CUSTOMERS.isEmpty())
        {
            System.out.println("No customers has registered yet.");
        }
        else
        {
            // Display all the customers for the user to choose
            displayCustomers();
            String customerID = input.customerIDInput(CUSTOMERS);
            currentCustomer = searchCustomer(customerID);

            // Display all the flights for the user to choose
            displayFlights();
            String flightID = input.flightIDInput(FLIGHTS);
            currentFlight = searchFlight(flightID);

            // Create a new flight ticket for the customer
            FlightClass flightClass = input.flightClassInput();
            FlightTicket flightTicket = new FlightTicket(flightClass,
                    currentCustomer, currentFlight);
            currentCustomer.bookFlight(flightTicket);
            FLIGHT_TICKETS.add(flightTicket);

            // Update the customer's loyalty points and
            // deduct the available seats of the flight
            currentCustomer.updateLoyaltyPoints(flightTicket.
                    getTicketLoyaltyPoints());
            currentFlight.deductAvailableSeats();

            System.out.println("---------------------------------------------");
            System.out.println("Ticket booked successfully.\n" +
                    flightTicket.toDetailedString());
        }
    }

    /**
     * Displays all the customers registered in the BunnyAirwaysSystem.
     */
    public void displayCustomers()
    {
        // Check if there are no customers registered
        if (CUSTOMERS.isEmpty())
        {
            System.out.println("No customers has registered yet.");
        }
        else
        {
            // Display all the customers registered
            for (Customer customer : CUSTOMERS)
            {
                System.out.println("---------------------------------------" +
                        "------\n" + customer);
            }
        }
    }

    /**
     * Displays all the flights available in the BunnyAirwaysSystem.
     */
    public void displayFlights()
    {
        // Check if there are no flights available
        if (FLIGHTS.isEmpty())
        {
            System.out.println("No FLIGHTS available.");
        }
        else
        {
            // Display all the flights available
            for (Flight flight : FLIGHTS)
            {
                System.out.println("---------------------------------------" +
                        "------\n" + flight);
            }
        }
    }

    /**
     * Gets the list of customers registered in the BunnyAirwaysSystem.
     * @return CUSTOMERS
     */
    public ArrayList<Customer> getCustomers()
    {
        return CUSTOMERS;
    }

    /**
     * Gets the list of flights available in the BunnyAirwaysSystem.
     * @return FLIGHTS
     */
    public ArrayList<Flight> getFlights()
    {
        return FLIGHTS;
    }

    /**
     * Gets the list of flight tickets booked in the BunnyAirwaysSystem.
     * @return FLIGHT_TICKETS
     */
    public ArrayList<FlightTicket> getFlightTickets()
    {
        return FLIGHT_TICKETS;
    }

    /**
     * Generates a daily report for the BunnyAirwaysSystem.
     */
    public void generateDailyReport()
    {
        Report dailyReport = new DailyReport();
        dailyReport.generateReport(this);
    }

    /**
     * Generates a monthly report for the BunnyAirwaysSystem.
     */
    public void generateMonthlyReport()
    {
        Report monthlyReport = new MonthlyReport();
        monthlyReport.generateReport(this);
    }

    /**
     * Registers a new customer to the BunnyAirwaysSystem.
     */
    public void registerCustomer()
    {
        Input input = new Input();
        String name = input.nameInput();
        String email = input.emailInput();
        Customer customer = new Customer(name, email);
        CUSTOMERS.add(customer);
        System.out.println("---------------------------------------------");
        System.out.println("Customer registered successfully.\n" + customer);
    }

    /**
     * Searches for a customer in the BunnyAirwaysSystem based on the
     * customer ID.
     * @param customerID the customer ID to search for
     * @return the customer found, null if not found
     */
    public Customer searchCustomer(String customerID)
    {
        Customer foundCustomer = null;
        // Search for the customer based on the customer ID
        for (Customer customer : CUSTOMERS)
        {
            if (customer.getCustomerID().equals(customerID))
            {
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

    /**
     * Searches for a flight in the BunnyAirwaysSystem based on the
     * flight ID.
     * @param flightID the flight ID to search for
     * @return the flight found, null if not found
     */
    public Flight searchFlight(String flightID)
    {
        Flight foundFlight = null;
        // Search for the flight based on the flight ID
        for (Flight flight : FLIGHTS)
        {
            if (flight.getFlightID().equals(flightID))
            {
                foundFlight = flight;
            }
        }
        return foundFlight;
    }

    /**
     * Searches for a flight ticket in the BunnyAirwaysSystem based on the
     * flight ID.
     * @param flightID the flight ID to search for
     * @return the flight ticket found, null if not found
     */
    public FlightTicket searchFlightTicket(String flightID)
    {
        FlightTicket foundFlightTicket = null;
        // Search for the flight ticket based on the flight ID
        for (FlightTicket flightTicket : FLIGHT_TICKETS)
        {
            if (flightTicket.getFlight().getFlightID().equals(flightID))
            {
                foundFlightTicket = flightTicket;
            }
        }
        return foundFlightTicket;
    }

    /**
     * View the bookings of a customer in the BunnyAirwaysSystem.
     */
    public void viewCustomerBookings()
    {
        Input input = new Input();
        if (CUSTOMERS.isEmpty())
        {
            System.out.println("No customers has registered yet.");
        }
        else
        {
            // Display all the customers for the user to choose
            displayCustomers();
            String customerID = input.customerIDInput(CUSTOMERS);
            Customer currentCustomer = searchCustomer(customerID);

            System.out.println("---------------------------------------------");
            System.out.println(currentCustomer);
            System.out.println("---------------------------------------------");
            // Display the bookings of the customer
            System.out.println("Customer's bookings:");
            for (FlightTicket flightTicket : currentCustomer.getBookedFlights())
            {
                // Display the booking details of the flight ticket
                System.out.println(flightTicket.bookingDetails());
                System.out.println("---------------------------------------" +
                        "------");
            }
            System.out.println("Customer's earned loyalty points: " +
                    currentCustomer.getLoyaltyPoints());
        }
    }
}
