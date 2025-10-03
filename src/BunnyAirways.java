/**
 * This class demonstrates a booking system for BunnyAirways
 * User acts as a manager who create customer's accounts
 * and help them to book flights
 * @author Leroy Lim Xin Aun
 * @version ver 1.0.1
 */
public class BunnyAirways
{
    /**
     * This is the main method which begins the program execution
     * @param args command-line arguments passed to the program
     */
    public static void main(String[] args)
    {
        // Create a new instance of the BunnyAirways class
        BunnyAirways bunnyAirways = new BunnyAirways();
        bunnyAirways.displayMainMenu();
    }

    /**
     * This method displays the main menu of the BunnyAirways system
     */
    public void displayMainMenu()
    {
        Input input = new Input();
        int userOption;
        do
        {
            userOption = input.mainMenuOption();
            handleMainMenuOption(userOption);
        } while (userOption != 7);
    }

    /**
     * This method handles the user's choice from the main menu
     * @param userOption the user's choice from the main menu
     */
    public void handleMainMenuOption(int userOption)
    {
        BunnyAirwaysSystem bunnyAirwaysSystem = new BunnyAirwaysSystem();
        // Switch statement to handle the user's choice
        switch (userOption)
        {
            case 1:
                // Register a new customer
                bunnyAirwaysSystem.registerCustomer();
                break;
            case 2:
                // Add a new flight
                bunnyAirwaysSystem.addNewFlight();
                break;
            case 3:
                // Book a flight ticket for a customer
                bunnyAirwaysSystem.bookFlightTicket();
                break;
            case 4:
                // View all bookings and earned points for a specific customer
                bunnyAirwaysSystem.viewCustomerBookings();
                break;
            case 5:
                // Generate a daily report
                bunnyAirwaysSystem.generateDailyReport();
                break;
            case 6:
                // Generate a monthly report
                bunnyAirwaysSystem.generateMonthlyReport();
                break;
            case 7:
                // Exit the system
                System.out.println("Exiting the system...");
                break;
        }
    }
}
