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

//        assigning value to ticketpool
        int maxTicketCapacity = config.getMaxTicketCapacity();
        TicketPool ticketPool = new TicketPool(maxTicketCapacity);
        List<Thread> threads = new ArrayList<>();

        System.out.println("Ticketpool created with max capacity :"+maxTicketCapacity);

//        creating vendor threads
        for (int i = 0; i< config.getNumberOfVendors();i++){

            Vendor vendor = new Vendor(i,ticketPool,config.getTicketReleaseRate(),config.getTicketsPerRelease());
            Thread vendorThread = new Thread(vendor,"Vendor-"+ i);
            threads.add(vendorThread);
            vendorThread.start();
        }

//        creating customer threads
        for (int i =0; i<config.getNumberOfCustomers();i++){
            Customer customer = new Customer(i,ticketPool, config.getCustomerRetirevalRate());
            Thread customerThread = new Thread(customer, "Customer-" + i);
            threads.add(customerThread);
            customerThread.start();
        }

//        stopping all threads for clear output
        for(Thread thread : threads){
            thread.interrupt();

            //        letting the program run for 10 seconds for clear output
            try{
                Thread.sleep(10000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

    }
}
