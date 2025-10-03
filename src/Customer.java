import java.util.ArrayList;

/**
 * Customer class is used to create a customer object
 * with the customer's details.
 * The customer can book flights and earn loyalty points
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class Customer
{
    private final char CUSTOMER_ID_PREFIX = 'C';
    private final int CUSTOMER_NUMBER;
    private static int customerNumberUpdate = 1000;
    private final String CUSTOMER_ID;
    private String name;
    private String email;
    ArrayList<FlightTicket> bookedFlights;
    private int loyaltyPoints;

    /**
     * Default constructor for Customer
     */
    public Customer()
    {
        this.name = "";
        this.email = "";
        this.loyaltyPoints = 0;
        bookedFlights = new ArrayList<FlightTicket>();
        CUSTOMER_NUMBER = 0;
        CUSTOMER_ID = "";
    }

    /**
     * Constructs a new Customer
     * with the specified name and email
     *
     * @param name name of the customer
     * @param email email of the customer
     */
    public Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.loyaltyPoints = 0;
        // Create a new ArrayList to store the booked flights
        bookedFlights = new ArrayList<FlightTicket>();
        // Update the customer number and customer ID for the new customer
        CUSTOMER_NUMBER = customerNumberUpdate++;
        CUSTOMER_ID = CUSTOMER_ID_PREFIX + Integer.toString(CUSTOMER_NUMBER);
    }

    /**
     * Books a flight ticket for the customer
     * @param flightTicket the flight ticket to be booked
     */
    public void bookFlight(FlightTicket flightTicket)
    {
        bookedFlights.add(flightTicket);
    }

    /**
     * Gets the customer ID of the customer
     * @return CUSTOMER_ID
     */
    public String getCustomerID()
    {
        return CUSTOMER_ID;
    }

    /**
     * Gets the email of the customer
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Gets the list of booked flights of the customer
     * @return bookedFlights
     */
    public ArrayList<FlightTicket> getBookedFlights()
    {
        return bookedFlights;
    }

    /**
     * Gets the loyalty points of the customer
     * @return loyaltyPoints
     */
    public int getLoyaltyPoints()
    {
        return loyaltyPoints;
    }

    /**
     * Gets the name of the customer
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the email of the customer
     * @param email the email of the customer
     * @return true if the email is valid, false otherwise
     */
    public boolean setEmail(String email)
    {
        boolean valid = false;
        Validation validate = new Validation();
        // Validate the email
        if (validate.validateEmail(email))
        {
            this.email = email;
            valid = true;
        }
        return valid;
    }

    /**
     * Updates the loyalty points of the customer
     * @param loyaltyPoints the loyalty points to be updated
     * @return true if the loyalty points is valid, false otherwise
     */
    public boolean updateLoyaltyPoints(int loyaltyPoints)
    {
        boolean valid = false;
        // Check if the loyalty points is not negative
        if (loyaltyPoints >= 0)
        {
            this.loyaltyPoints += loyaltyPoints;
            valid = true;
        }
        return valid;
    }

    /**
     * Sets the name of the customer
     * @param name the name of the customer
     * @return true if the name is valid, false otherwise
     */
    public boolean setName(String name)
    {
        boolean valid = false;
        Validation validate = new Validation();
        // Check if the name is not empty
        if (!validate.isEmptyInput(name))
        {
            this.name = name;
            valid = true;
        }
        return valid;
    }

    /**
     * Returns the string representation of the customer
     * @return output
     */
    public String toString()
    {
        String output;
        output = "Customer ID: " + getCustomerID() + "\n" +
                "Name: " + getName() + "\n" +
                "Email: " + getEmail();
        return output;
    }
}
