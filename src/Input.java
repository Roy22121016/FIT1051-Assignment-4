import java.util.ArrayList;
import java.util.Scanner;

/**
 * Input class is responsible for prompting the user for input
 * validating the input and returning the valid input to the system.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class Input
{
    Validation validate = new Validation();
    Scanner scanner = new Scanner(System.in);
    // Constructor
    public Input()
    {

    }

    /**
     * This method prompts the user to enter the main menu option
     * @param customers the list of registered customers in the system
     * @return validCustomerID the valid customer ID entered by the user
     */
    public String customerIDInput(ArrayList<Customer> customers)
    {
        String validCustomerID;
        // Prompt the user to enter the customer ID repeatedly
        // until a valid ID is entered
        do
        {
            System.out.println("---------------------------------------------");
            System.out.println("Enter the customer's ID to manage/view" +
                    " bookings: ");
            validCustomerID = scanner.nextLine();
            // Print error message if the customer ID is empty
            if (validate.isEmptyInput(validCustomerID))
            {
                System.out.println("Customer ID cannot be empty. " +
                        "Please try again.");
            }
            // Print error message if the customer ID is not found
            else if (!validate.validateCustomerID(validCustomerID, customers))
            {
                System.out.println("Customer ID not found. Please try again.");
            }
        } while (validate.isEmptyInput(validCustomerID) ||
                !validate.validateCustomerID(validCustomerID, customers));
        return validCustomerID;
    }

    /**
     * This method prompts the user to enter the flight ID
     * @param flights the list of registered flights in the system
     * @return validFlightID the valid flight ID entered by the user
     */
    public String flightIDInput(ArrayList<Flight> flights)
    {
        String validFlightID;
        // Prompt the user to enter the flight ID repeatedly until
        // a valid flight ID is entered
        do
        {
            System.out.println("---------------------------------------------");
            System.out.println("Enter the flight's ID to book a ticket: ");
            validFlightID = scanner.nextLine();
            // Print error message if the flight ID is empty
            if (validate.isEmptyInput(validFlightID))
            {
                System.out.println("Flight ID cannot be empty." +
                        " Please try again.");
            }
            // Print error message if the flight ID is not found
            else if (!validate.validateFlightID(validFlightID, flights))
            {
                System.out.println("Flight ID not found. Please try again.");
            }
            // Print error message if the flight is fully booked
            else if (!validate.validateFlightAvailability(flights, validFlightID))
            {
                System.out.println("This flight is fully booked. " +
                        "Please choose another flight.");
            }
        } while (validate.isEmptyInput(validFlightID) ||
                !validate.validateFlightID(validFlightID, flights) ||
                !validate.validateFlightAvailability(flights, validFlightID));
        return validFlightID;
    }

    /**
     * This method prompts the user to enter the flight class
     * @return flightClass the valid flight class entered by the user
     */
    public FlightClass flightClassInput()
    {
        FlightClass flightClass = null;
        String userInput;
        int userOption;
        int totalOptions = 3;
        // Prompt the user to enter the flight class repeatedly until
        // a valid flight class is entered
        do
        {
            System.out.print("""
                    ---------------------------------------------
                    1. Economy
                    2. Business
                    3. First Class
                    Please select the flight class (1,2,3):
                    """);
            userInput = scanner.nextLine();
            // Print error message if the flight class is invalid
            if (!validate.validateFlightClass(userInput, totalOptions))
            {
                System.out.println("Invalid option. Please try again.");
            }
        } while (!validate.validateFlightClass(userInput, totalOptions));
        userOption = Integer.parseInt(userInput);
        // Assign the flight class based on the user's choice
        switch (userOption)
        {
            case 1:
                flightClass = FlightClass.ECONOMY;
                break;
            case 2:
                flightClass = FlightClass.BUSINESS;
                break;
            case 3:
                flightClass = FlightClass.FIRST_CLASS;
                break;
        }
        return flightClass;
    }

    /**
     * This method prompts the user to enter the main menu option
     * @return userOption the valid main menu option entered by the user
     */
    public int mainMenuOption()
    {
        int totalOptions = 7;
        String userInput;
        int userOption;
        // Prompt the user to enter the main menu option repeatedly until
        // a valid option is entered
        do
        {
            System.out.print("""
                    ---------------------------------------------
                    This is the Bunny Airways main system menu.
                    1. Register a new customer.
                    2. Add a new flight to the system.
                    3. Book a flight ticket.
                    4. View all bookings and earned points for a specific customer.
                    5. Generate a daily report showing total bookings, revenue, and remaining seats per
                       flight.
                    6. Generate a monthly report summarizing total passengers flown and total revenue.
                    7. Exit the system.
                    Please select an option:
                    """);
            userInput = scanner.nextLine();
            // Print error message if the main menu option is invalid
            if (!validate.validateMainMenuOption(userInput, totalOptions))
            {
                System.out.println("Invalid option. Please try again.");
            }
        } while (!validate.validateMainMenuOption(userInput, totalOptions));
            userOption = Integer.parseInt(userInput);
            return userOption;
    }

    /**
     * This method prompts the user to enter the customer's email address
     * @return validEmail the valid email address entered by the user
     */
    public String emailInput()
    {
        String validEmail = "";
        // Prompt the user to enter the email address repeatedly until
        // a valid email address is entered
        do
        {
            System.out.println("Enter the customer's email address (example@mail.com): ");
            validEmail = scanner.nextLine();
            // Print error message if the email address is invalid
            if (!validate.validateEmail(validEmail))
            {
                System.out.println("Invalid email address. Please try again.");
            }
        } while (!validate.validateEmail(validEmail));
        return validEmail;
    }

    /**
     * This method prompts the user to enter the customer's name
     * @return validName the valid name entered by the user
     */
    public String nameInput()
    {
        String validName;
        // Prompt the user to enter the customer's name repeatedly until
        // a valid name is entered
        do
        {
            System.out.println("Enter the customer's name: ");
            validName = scanner.nextLine();
            // Print error message if the name is empty
            if (validate.isEmptyInput(validName))
            {
                System.out.println("Customer's name cannot be empty. Please try again.");
            }
        } while (validate.isEmptyInput(validName));
        return validName;
    }

    /**
     * This method prompts the user to enter the base fare of the flight
     * @return baseFare the valid base fare entered by the user
     */
    public double baseFareInput()
    {
        double baseFare;
        String userInput;
        // Prompt the user to enter the base fare repeatedly until
        // a valid base fare is entered
        do
        {
            System.out.println("Enter the base fare of the flight: ");
            userInput = scanner.nextLine();
            if (validate.isEmptyInput(userInput))
            {
                System.out.println("Base fare cannot be empty. " +
                        "Please try again.");
            }
            // Print error message if the base fare is less than or equal to 0
            else if (!validate.validateBaseFare(userInput))
            {
                System.out.println("Invalid input. Please enter a " +
                        "positive number.");
            }

        } while (validate.isEmptyInput(userInput)
                || !validate.validateBaseFare(userInput));
        baseFare = Double.parseDouble(userInput);
        return baseFare;
    }

    /**
     * This method prompts the user to enter the route of the flight
     * @return route the valid flight route entered by the user
     */
    public String routeInput()
    {
        String validRoute;
        // Prompt the user to enter the route repeatedly until
        // a valid route is entered
        do
        {
            System.out.println("Enter the route of the flight: ");
            validRoute = scanner.nextLine();
            // Print error message if the route is empty
            if (validate.isEmptyInput(validRoute))
            {
                System.out.println("Route cannot be empty. Please try again.");
            }
        } while (validate.isEmptyInput(validRoute));
        return validRoute;
    }

    /**
     * This method prompts the user to enter the
     * total number of seats for the flight
     * @return totalSeats the valid total number of seats entered by the user
     */
    public int totalSeatsInput()
    {
        int totalSeats;
        String userInput;
        // Prompt the user to enter the total number of seats repeatedly until
        // a valid number of seats is entered
        do
        {
            System.out.println("Enter the total number of seats " +
                    "for the flight: ");
            userInput = scanner.nextLine();
            if (validate.isEmptyInput(userInput))
            {
                System.out.println("Total seats cannot be empty." +
                        " Please try again.");
            }
            // Print error message if the total number of seats is
            // less than or equal to 0
            else if (!validate.validateTotalSeats(userInput))
            {
                System.out.println("Invalid input. Please enter " +
                        "a positive integer.");
            }
        } while (validate.isEmptyInput(userInput) ||
                !validate.validateTotalSeats(userInput));
        totalSeats = Integer.parseInt(userInput);
        return totalSeats;
    }
}
