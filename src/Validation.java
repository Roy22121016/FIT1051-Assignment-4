import java.util.ArrayList;

/**
 * This class is used to validate the input from the user.
 * @author Leroy Lim Xin Aun
 * @version ver 1.0.1
 */
public class Validation
{
    // Constructor
    public Validation()
    {

    }

    /**
     * This method is used to validate the empty input
     * @param input the input from the user
     * @return true if the input is empty, false otherwise
     */
    public boolean isEmptyInput(String input)
    {
        boolean emptyInput = false;
        // Check if the input is empty or blank
        if (input.isEmpty() || input.isBlank())
        {
            emptyInput = true;
        }
        return emptyInput;
    }

    /**
     * This method is used to validate the base fare
     * @param inputFare the input base fare from the user
     * @return true if the base fare is valid, false otherwise
     */
    public boolean validateBaseFare(String inputFare)
    {
        boolean validInput = false;
        // Check if the input base fare is a double and greater than 0
        try
        {
            double fare = Double.parseDouble(inputFare);
            if (fare > 0)
            {
                validInput = true;
            }
        }
        // Catch the NumberFormatException if the input is not a double
        catch (NumberFormatException e)
        {
            validInput = false;
        }
        return validInput;
    }

    /**
     * This method is used to validate the customer ID
     * @param inputID the input customer ID from the user
     * @param customers the list of registered customers
     * @return true if the customer ID is valid, false otherwise
     */
    public boolean validateCustomerID(String inputID,
                                      ArrayList<Customer> customers)
    {
        boolean validInput = false;
        // Check if the input customer ID is in the list of registered customers
        for (Customer customer : customers)
        {
            if (customer.getCustomerID().equals(inputID))
            {
                validInput = true;
            }
        }
        return validInput;
    }

    /**
     * This method is used to validate the email
     * @param inputEmail the input email from the user
     * @return true if the email is valid, false otherwise
     */
    public boolean validateEmail(String inputEmail)
    {
        char emailCharacter;
        boolean validInput = true;
        // Check if the input email contains '@' and no spaces
        if (!inputEmail.contains("@") || inputEmail.contains(" "))
        {
            validInput = false;
        }

        // Check if the '@' is not at the start or end of the email
        for (int i = 0; i < inputEmail.length(); i++)
        {
            emailCharacter = inputEmail.charAt(i);
            if (emailCharacter == '@')
            {
                if (i == 0 || i == (inputEmail.length() - 1))
                {
                    validInput = false;
                }
            }
        }
        return validInput;
    }

    /**
     * This method is used to validate the flight availability
     * @param flights the list of registered flights
     * @param flightID the flight ID
     * @return true if the flight is available, false otherwise
     */
    public boolean validateFlightAvailability(ArrayList<Flight> flights
            , String flightID)
    {
        boolean validInput = false;
        // Check if the flight is not fully booked
        for (Flight flight : flights)
        {
            if (flight.getFlightID().equals(flightID))
            {
                validInput = !flight.fullBooked();
            }
        }
        return validInput;
    }

    /**
     * This method is used to validate the flight ID
     * @param inputID the input flight ID from the user
     * @param flights the list of registered flights
     * @return true if the flight ID is valid, false otherwise
     */
    public boolean validateFlightID(String inputID, ArrayList<Flight> flights)
    {
        boolean validInput = false;
        // Check if the input flight ID is in the list of registered flights
        for (Flight flight : flights)
        {
            if (flight.getFlightID().equals(inputID))
            {
                validInput = true;
            }
        }
        return validInput;
    }

    /**
     * This method is used to validate the flight class
     * @param inputClass the input flight class from the user
     * @param totalOptions the total number of flight classes
     * @return true if the flight class is valid, false otherwise
     */
    public boolean validateFlightClass(String inputClass, int totalOptions)
    {
        boolean validInput = false;
        int option = 1;
        // Check if the input flight class is within the range of options
        try
        {
            option = Integer.parseInt(inputClass);
            if (option >= 1 && option <= totalOptions)
            {
                validInput = true;
            }
        }
        // Catch the NumberFormatException if the input is not an integer
        catch (NumberFormatException e)
        {
            validInput = false;
        }
        return validInput;
    }

    /**
     * This method is used to validate the main menu option
     * @param inputOption the input option from the user
     * @param totalOptions the total number of main menu options
     * @return true if the main menu option is valid, false otherwise
     */
    public boolean validateMainMenuOption(String inputOption, int totalOptions)
    {
        boolean validInput = false;
        // Check if the input option is within the range of options
        try
        {
            int option = Integer.parseInt(inputOption);
            if (option >= 1 && option <= totalOptions)
            {
                validInput = true;
            }
        }
        // Catch the NumberFormatException if the input is not an integer
        catch (NumberFormatException e)
        {
            validInput = false;
        }
        return validInput;
    }

    /**
     * This method is used to validate the total seats input from the user
     * @param inputSeats the input name from the user
     * @return true if the input seats is valid, false otherwise
     */
    public boolean validateTotalSeats(String inputSeats)
    {
        boolean validInput = false;
        // Check if the input total seats is an integer and greater than 0
        try
        {
            int seats = Integer.parseInt(inputSeats);
            if (seats > 0)
            {
                validInput = true;
            }
        }
        // Catch the NumberFormatException if the input is not an integer
        catch (NumberFormatException e)
        {
            validInput = false;
        }
        return validInput;
    }
}
