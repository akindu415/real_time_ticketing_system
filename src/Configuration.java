import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int ticketsPerRelease;
    private int customerRetirevalRate;
    private int maxTicketCapacity;
    private int numberOfVendors;
    private int numberOfCustomers;

    public void loadFromInput(Scanner scanner) {
        while (true) {
            System.out.println("Enter total number of tickets: ");
            totalTickets = scanner.nextInt();
            if (totalTickets >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter ticket release rate (ms): ");
            ticketReleaseRate = scanner.nextInt();
            if (ticketReleaseRate >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter tickets per release: ");
            ticketsPerRelease = scanner.nextInt();
            if (ticketsPerRelease >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter customer retrieval rate: ");
            customerRetirevalRate = scanner.nextInt();
            if (customerRetirevalRate >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter max ticket capacity: ");
            maxTicketCapacity = scanner.nextInt();
            if (maxTicketCapacity >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter number of Vendors: ");
            numberOfVendors = scanner.nextInt();
            if (numberOfVendors >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }

        while (true) {
            System.out.println("Enter number of Customers: ");
            numberOfCustomers = scanner.nextInt();
            if (numberOfCustomers >= 0) break;
            System.out.println("Invalid input. Please enter a non-negative number.");
        }
    }


    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getNumberOfVendors() {
        return numberOfVendors;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getTicketsPerRelease() {
        return ticketsPerRelease;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public int getCustomerRetirevalRate() {
        return customerRetirevalRate;
    }

    public int getTotalTickets() {return totalTickets;}
}
