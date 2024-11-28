import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        configuration of the system
        Configuration config = new Configuration();
        config.loadFromInput(scanner);
        System.out.println("System configuration completed");

//        assigning value to tocketpool
        int maxTicketCapacity = config.getMaxTicketCapacity();
        TicketPool ticketPool = new TicketPool(maxTicketCapacity);
        List<Thread> threads = new ArrayList<>();

        System.out.println("Ticketpool created with max capacity :"+maxTicketCapacity);

//        creating vendor
        for (int i = 0; i< config.getNumberOfVendors();i++){
            System.out.println("Enter name of the vendor :");
            String vname = scanner.next();
            Vendor vendor = new Vendor(i,vname,ticketPool, config.getTicketReleaseRate(), config.getTicketsPerRelease());
            Thread vendorThread = new Thread(vendor,"Vendor-"+ i);
            threads.add(vendorThread);
            vendorThread.start();
        }

//        creating customer
        for (int i =0; i<config.getNumberOfCustomers();i++){
            System.out.println("Enter name of the customer :");
            String cname = scanner.next();
            Customer customer = new Customer(i,cname, config.getCustomerRetirevalRate(),ticketPool,);
            Thread customerThread = new Thread(customer, "Customer-" + i);
            threads.add(customerThread);
            customerThread.start();
        }

    }
}
