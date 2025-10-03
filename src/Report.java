/**
 * Report class that generates a report for the BunnyAirwaysSystem.
 * Abstract class that is extended by DailyReport and MonthlyReport classes.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public abstract class Report
{
    public Report()
    {

    }

    /**
     * Calculates the total revenue of the BunnyAirwaysSystem.
     * @param system the BunnyAirwaysSystem to calculate the revenue for
     * @return totalRevenue
     */
    public double calculateRevenue(BunnyAirwaysSystem system)
    {
        double totalRevenue = 0;
        for (FlightTicket flightTicket : system.getFlightTickets())
        {
            totalRevenue += flightTicket.getTicketFare();
        }
        return totalRevenue;
    }

    /**
     * Calculates the total revenue of a specific flight
     * in the BunnyAirwaysSystem.
     * @param system the BunnyAirwaysSystem to calculate the revenue for
     * @param flight the flight to calculate the revenue for
     * @return totalSpecificRevenue
     */
    public double calculateSpecificRevenue(BunnyAirwaysSystem system,
                                           Flight flight)
    {
        double totalSpecificRevenue = 0;
        for (FlightTicket flightTicket : system.getFlightTickets())
        {
            if (flightTicket.getFlight().getFlightID()
                    .equals(flight.getFlightID()))
            {
                totalSpecificRevenue += flightTicket.getTicketFare();
            }
        }
        return totalSpecificRevenue;
    }

    /**
     * Generates a report for the BunnyAirwaysSystem.
     * Abstract method that is overridden by DailyReport and MonthlyReport
     * @param system the BunnyAirwaysSystem to generate the report for
     */
    public abstract void generateReport(BunnyAirwaysSystem system);
}
