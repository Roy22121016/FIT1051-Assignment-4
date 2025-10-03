/**
 * MonthlyReport class that extends Report class and generates a monthly report
 * for the BunnyAirwaysSystem.
 * Author: Leroy Lim Xin Aun
 * Version: ver 1.0.1
 */
public class MonthlyReport extends Report
{
    public MonthlyReport()
    {
        super();
    }

    /**
     * Overrides the generateReport method in the Report class
     * to generate a monthly report for the BunnyAirwaysSystem.
     * @param system the BunnyAirwaysSystem to generate the report for
     */
    @Override
    public void generateReport(BunnyAirwaysSystem system)
    {
        int totalPassengers = system.getFlightTickets().size();
        double totalRevenue = calculateRevenue(system);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("Monthly Report");
        System.out.println("------------------------");
        System.out.println("Total passengers flown: " + totalPassengers +
                "\nTotal revenue: $%.2f".formatted(totalRevenue));
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
    }
}
