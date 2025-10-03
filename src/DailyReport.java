/**
 * DailyReport class that extends Report class and generates a daily report
 * for the BunnyAirwaysSystem.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class DailyReport extends Report
{
    public DailyReport()
    {
        super();
    }

    /**
     * Overrides the generateReport method in the Report class
     * to generate a daily report for the BunnyAirwaysSystem.
     * @param system the BunnyAirwaysSystem to generate the report for
     */
    @Override
    public void generateReport(BunnyAirwaysSystem system)
    {
        // Get the total number of bookings made today
        int totalBookings = system.getFlightTickets().size();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Daily Report");
        System.out.println("---------------------------------------------");
        System.out.println("Total bookings: " + totalBookings);
        // If there are no bookings made today, display a message
        if (totalBookings == 0)
        {
            System.out.println("No bookings made today.");
        }
        // Otherwise, display the revenue for each flight
        else
        {
            displayFlightRevenue(system);
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    /**
     * Displays the revenue for each flight in the BunnyAirwaysSystem
     * @param system the BunnyAirwaysSystem to display the revenue for
     */
    public void displayFlightRevenue(BunnyAirwaysSystem system)
    {
        for (Flight flight : system.getFlights())
        {
            System.out.println(flight);
            System.out.println("Total revenue for this flight: $%.2f"
                    .formatted(calculateSpecificRevenue(system, flight)));
            System.out.println("---------------------------------------------");
        }
    }
}
