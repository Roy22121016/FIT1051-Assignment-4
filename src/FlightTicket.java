/**
 * FlightTicket class represents a ticket for a flight.
 * It contains the ticket ID, flight class, customer, flight, and ticket fare.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class FlightTicket
{
    private final char TICKET_ID_PREFIX = 'T';
    private final int TICKET_NUMBER;
    private static int ticketNumberUpdate = 1000;
    private final String TICKET_ID;
    private int ticketLoyaltyPoints;
    private FlightClass flightClass;
    Customer customer;
    Flight flight;

    // Default constructor for FlightTicket
    public FlightTicket()
    {
        this.customer = new Customer();
        this.flight = new Flight();
        this.flightClass = null;
        TICKET_NUMBER = 0;
        TICKET_ID = "0";
        this.ticketLoyaltyPoints = 0;
    }

    // Constructs a new FlightTicket
    // with the specified flight class, customer and flight
    public FlightTicket(FlightClass flightClass, Customer customer,
                        Flight flight)
    {
        this.customer = customer;
        this.flight = flight;
        this.flightClass = flightClass;
        // Update the ticket number and ticket ID for the new ticket
        TICKET_NUMBER = ticketNumberUpdate++;
        // Concatenate the ticket ID prefix with the ticket number
        TICKET_ID = TICKET_ID_PREFIX + Integer.toString(TICKET_NUMBER);
        setTicketLoyaltyPoints();
    }

    /**
     * String representation of the booking details
     * @return output
     */
    public String bookingDetails()
    {
        String output;
        output = "Ticket ID: " + getTicketID() + "\n"
                + "Flight Class: " + getFlightClass() + "\n"
                + "Flight ID: " + getFlight().getFlightID() + "\n"
                + "Route: " + getFlight().getRoute();
        return output;
    }

    /**
     * Gets the customer of the ticket
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Gets the flight of the ticket
     * @return flight
     */
    public Flight getFlight()
    {
        return flight;
    }

    /**
     * Gets the flight class of the ticket
     * @return flightClass
     */
    public FlightClass getFlightClass()
    {
        return flightClass;
    }

    /**
     * Gets the ticket ID of the ticket
     * @return TICKET_ID
     */
    public String getTicketID()
    {
        return TICKET_ID;
    }

    /**
     * Gets the ticket fare of the ticket
     * @return ticketFare
     */
    public double getTicketFare()
    {
        double ticketFare = 0;
        // Assign the ticket fare based on the flight class
        switch (getFlightClass())
        {
            case ECONOMY:
                ticketFare = getFlight().getBaseFare();
                break;
            case BUSINESS:
                ticketFare = getFlight().getBaseFare() * 2.0;
                break;
            case FIRST_CLASS:
                ticketFare = getFlight().getBaseFare() * 4.0;
                break;
        }
        return ticketFare;
    }

    /**
     * Gets the loyalty points of the ticket
     * @return ticketLoyaltyPoints
     */
    public int getTicketLoyaltyPoints()
    {
        return ticketLoyaltyPoints;
    }

    /**
     * Sets the customer of the ticket
     * @param customer the customer of the ticket
     */
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    /**
     * Set the loyalty points of the ticket
     */
    public void setTicketLoyaltyPoints()
    {
        // Assign the loyalty points based on the flight class
        switch (getFlightClass())
        {
            case ECONOMY:
                this.ticketLoyaltyPoints = 15;
                break;
            case BUSINESS:
                this.ticketLoyaltyPoints = 30;
                break;
            case FIRST_CLASS:
                this.ticketLoyaltyPoints = 50;
                break;
        }
    }

    /**
     * String representation of the detailed ticket details
     * @return output
     */
    public String toDetailedString()
    {
        String output;
        output = "Ticket ID: " + getTicketID() + "\n"
               + "Flight Class: " + getFlightClass() + "\n"
               + "Ticket Fare: $%.2f".formatted(getTicketFare()) + "\n"
               + "Loyalty Points: " + getTicketLoyaltyPoints() + "\n";
        output += customer + "\n";
        output += "Flight ID: " + getFlight().getFlightID() + "\n"
                + "Route: " + getFlight().getRoute();
        return output;
    }
}
