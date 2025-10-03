/**
 * This class creates a Flight with a flight ID, route, total seats,
 * available seats and base fare
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class Flight
{
    private final char FLIGHT_ID_PREFIX = 'F';
    private final int FLIGHT_NUMBER;
    private final int TOTAL_SEATS;
    private final String FLIGHT_ID;
    private static int flightNumberUpdate = 1000;
    private double baseFare;
    private int availableSeats;
    private String route;

    /**
     * Default constructor for Flight
     */
    public Flight()
    {
        this.route = "";
        this.TOTAL_SEATS = 0;
        this.availableSeats = 0;
        this.baseFare = 0;
        FLIGHT_NUMBER = 0;
        FLIGHT_ID = "0";
    }

    /**
     * Constructs a new Flight
     * @param route route of the flight
     * @param totalSeats total seats of the flight
     * @param baseFare base fare of the flight
     */
    public Flight(String route, int totalSeats, double baseFare)
    {
        this.route = route;
        this.TOTAL_SEATS = totalSeats;
        this.availableSeats = totalSeats;
        this.baseFare = baseFare;
        // Update the flight number and flight ID for the new flight
        FLIGHT_NUMBER = flightNumberUpdate++;
        // Concatenate the flight ID prefix with the flight number
        FLIGHT_ID = FLIGHT_ID_PREFIX + Integer.toString(FLIGHT_NUMBER);
    }

    /**
     * Checks if the flight is fully booked
     * @return true if the flight is fully booked, false otherwise
     */
    public boolean fullBooked()
    {
        boolean full = false;
        if (getAvailableSeats() == 0)
        {
            full = true;
        }
        return full;
    }

    /**
     * Gets the available seats of the flight
     * @return availableSeats
     */
    public int getAvailableSeats()
    {
        return availableSeats;
    }

    /**
     * Gets the base fare of the flight
     * @return baseFare
     */
    public double getBaseFare()
    {
        return baseFare;
    }

    /**
     * Gets the flight ID of the flight
     * @return FLIGHT_ID
     */
    public String getFlightID()
    {
        return FLIGHT_ID;
    }

    /**
     * Gets the route of the flight
     * @return route
     */
    public String getRoute()
    {
        return route;
    }

    /**
     * Gets the total seats of the flight
     * @return TOTAL_SEATS
     */
    public int getTotalSeats()
    {
        return TOTAL_SEATS;
    }

    /**
     * Deducts the available seats of the flight
     * @return true if the available seats are deducted, false otherwise
     */
    public boolean deductAvailableSeats()
    {
        boolean valid = false;
        // Check if the current available seats is within the range
        if (availableSeats >= 0 && availableSeats <= getTotalSeats())
        {
            this.availableSeats -= 1;
            valid = true;
        }
        return valid;
    }

    /**
     * Set the base fare of the flight
     * @param baseFare base fare of the flight
     * @return true if the base fare is set, false otherwise
     */
    public boolean setBaseFare(double baseFare)
    {
        boolean valid = false;
        // Check if the input base fare is greater than 0
        if (baseFare > 0)
        {
            this.baseFare = baseFare;
            valid = true;
        }
        return valid;
    }

    /**
     * Set the route of the flight
     * @param route route of the flight
     * @return true if the route is set, false otherwise
     */
    public boolean setRoute(String route)
    {
        boolean valid = false;
        // Check if the input route is not empty
        if (!route.isEmpty())
        {
            this.route = route;
            valid = true;
        }
        return valid;
    }

    /**
     * Returns the string representation of the Flight
     * @return output
     */
    public String toString()
    {
        String output;
        output = "Flight ID: " + getFlightID() + "\n"
               + "Route: " + getRoute() + "\n"
               + "Total Seats: " + getTotalSeats() + "\n"
               + "Available Seats: " + getAvailableSeats() + "\n"
               + "Base fare: $%.2f ".formatted(getBaseFare());
        return output;
    }
}
